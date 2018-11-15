package controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import dao.DaoAdministrador;
import dao.DaoArea;
import dao.DaoAutor;
import dao.DaoCategoria;
import dao.DaoConvidado;
import dao.DaoEditora;
import dao.DaoLivro;
import dao.DaoUsuario;
import model.Administrador;
import model.Area;
import model.Autor;
import model.Categoria;
import model.Convidado;
import model.Editora;
import model.Livro;
import model.Usuario;



public class Fachada {
	
	private static Usuario logado = null;
	private static DaoUsuario daousuario = new DaoUsuario();
	private static DaoAdministrador daoadm = new DaoAdministrador();
	private static DaoConvidado daoconvidado = new DaoConvidado();
	private static DaoAutor daoautor = new DaoAutor();
	private static DaoLivro daolivro = new DaoLivro();
	private static DaoCategoria daocategoria = new DaoCategoria();
	private static DaoArea daoarea = new DaoArea();
	private static DaoEditora daoeditora = new DaoEditora();
	
	public static void inicializar(){
		Dao.open();
	}

	public static void finalizar(){
		Dao.close();
	}
	
	
	
	/********************** Login **********************/
	
	public static void login(String email, String senha) throws Exception {
		Dao.begin();
		if(logado != null)
			throw new Exception ("Já existe um usuário logado no sistema!");
		if (email.isEmpty()){
			throw new Exception("Preencha o campo E-mail corretamente!");
		}
		if (senha.isEmpty()){
			throw new Exception("Preencha o campo Senha corretamente!");
		}
		Usuario user = daousuario.readyLogin(email, senha);
		if(user == null)
			throw new Exception ("Login não foi possível! Dados E-mail ou Senha Inválidos!");
		logado = user;
	}

	public static void logoff() throws Exception {	
		if(logado == null)
			throw new Exception ("Não existe um usuário logado no sistema!");
		logado = null;
	}
	
	
	
	/********************** Usuario **********************/	
	
	public static boolean verificaUsuario(String email, String nome) 
			throws  Exception {
		Dao.begin();			
		Usuario u = daousuario.readyUsuario(email, nome);
		if(u != null) {
			Dao.rollback();
			throw new Exception("Usuário já cadastrado!: " + nome);
		}
		
		return true;
	}
	
	
	/********************** Adm **********************/	
	
	public static Usuario cadastrarAdm(String nome, String login, String senha, String email, String token) {
		Dao.begin();			
		Administrador adm =  new Administrador(nome, login, senha, email, token);
		daoadm.create(adm);		
		Dao.commit();
		return adm;
	}
	
	
	
	/********************** Convidado **********************/	
	public static Convidado cadastrarConvidado(String nome, String login, String senha, String email, BufferedImage bf) 
			throws  Exception {
		
			verificaUsuario(email,nome); 			
			Convidado c = new Convidado(nome, login, senha, email, bf);
			daoconvidado.create(c);		
			Dao.commit();
			return c;
		
	}
	
	
	
	/********************** Autor **********************/	
	
	public static Autor cadastrarAutor(String nome, String login, String senha, String email, String token, 
			BufferedImage bf, String cidade, String estado, String pais, ArrayList<Area> areas, 
			ArrayList<String> telefones, ArrayList<String> ocupacoes ) 
			throws  Exception {
	
			verificaUsuario(email,nome);
			Autor au = new Autor(nome,login,senha, email,token, bf, cidade,estado, pais);
			
			for(String o : ocupacoes)
				au.addOcupacao(o);
			
			for(String t : telefones)
				au.addTelefone(t);
			
			
			for(Area a : areas) {
				au.addAtuacao(a);
			}
			
			daoautor.create(au);		
			Dao.commit();
			
			return au;

	}
	
	
	public static Autor apagarAutor(String nome, int id) throws  Exception{
		Dao.begin();			
		Autor au = daoautor.read(id);
		if(au == null)throw new Exception("Autor não cadastrado!:" + nome);
		
		if(au.getLivros() != null){
			ArrayList<Livro> livros = au.getLivros();
			for(Livro l : livros) {
				retirarLivroAutor(au.getId(), l.getTitulo());
			}
		}
		
		if(au.getAtuacoes() != null){
			ArrayList<Area> areas = au.getAtuacoes();
			for(Area a : areas) {
				retirarAutorArea(au.getId(), a.getNome());
			}
		}
		daoautor.delete(au);		
		Dao.commit();
		return au;
	}
	
	
	public static List<Autor> listarAutores() {
		List<Autor> autores = daoautor.readAll();
		return autores;		
	}
	
	
	public static void inserirLivroAutor(int id, String nome) throws  Exception {

		Autor au = daoautor.read(id);
		if(au == null) {
			Dao.rollback();
			throw new Exception("Autor cadastrado!: " + nome);
		}

		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		if(au.locLivro(nome) != null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") já pertecence ao autor: " + au.getNome() );
		}

		au.addLivro(l);
		daoautor.update(au);		
		daolivro.update(l);			
		Dao.commit();
	}

	public static void retirarLivroAutor(int id, String nome) throws  Exception {
			

		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		Autor au = daoautor.read(id);
		if(au.locLivro(nome) == null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") não pertecence ao autor: " + au.getNome() );
		}

		au.delLivro(l);
		l.delAutor(au);
		daoautor.update(au);
		daolivro.update(l);		// Cuidado
		Dao.commit();
	}
	
	
	/********************** Categoria **********************/
	
	public static Categoria cadastrarCategoria(String nome) 
			throws  Exception {
		Dao.begin();			
		Categoria c = daocategoria.readCategoriaByNome(nome);
		if(c != null) {
			Dao.rollback();
			throw new Exception("Categoria já cadastrada!: " + nome);
		}
		
		c = new Categoria(nome);
		daocategoria.create(c);		
		Dao.commit();
		return c;
	}
	
	
	public static Categoria apagarCategoria(String nome, int id) throws  Exception{
		Dao.begin();			
		Categoria c = daocategoria.read(id);
		if(c == null)throw new Exception("Categoria não cadastrada!:" + nome);
		

		if(c.getLivros() != null){
			
			ArrayList<Livro> livros = c.getLivros();
			for(Livro l : livros) {
				retirarLivroCategoria(c.getId(), l.getTitulo());
			}
		}
		daocategoria.delete(c);		
		Dao.commit();
		return c;
	}
	
	
	public static Categoria consultarCategoria(int id) 
			throws  Exception {
		Dao.begin();			
		Categoria c = daocategoria.read(id);
		if(c == null) {
			Dao.rollback();
			throw new Exception("Categoria não Encontrada!: ");
		}
		return c;
	}
	
	
	public static Categoria alterarCategoria(int id, String nome) 
			throws  Exception {
		Dao.begin();			
		Categoria c = consultarCategoria(id);
		c.setNome(nome);
		daocategoria.update(c);		
		Dao.commit();
		return c;
	}
	
	public static List<Categoria> listarCategorias() throws  Exception {
		Dao.begin();
		List<Categoria> categorias = daocategoria.readAll();
		if(categorias == null) {
			throw new Exception("Nenhuma categoria cadastrada!: ");
		}
		return categorias;		
	}
	
	
	public static void inserirLivroCategoria(int id, String nome) throws  Exception {
		
		Categoria c = daocategoria.read(id);
		if(c == null) {
			Dao.rollback();
			throw new Exception("Categoria não cadastrada!: " + nome);
		}

		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		if(c.locLivro(nome) != null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") já se contra na categoria " + c.getNome() );
		}

		c.addLivro(l);
		daocategoria.update(c);		
		daolivro.update(l);			
		Dao.commit();
	}

	public static void retirarLivroCategoria(int id, String nome) throws  Exception {			
		
		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		Categoria c = daocategoria.read(id);
		if(c.locLivro(nome) == null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") não se contra na categoria " + c.getNome() );
		}

		c.delLivro(l);
		l.delCategoria(c);
		daocategoria.update(c);
		daolivro.update(l);		// Cuidado
		Dao.commit();
	}
	
	
	
	
	

	/********************** Area **********************/
	
	public static Area cadastrarArea(String nome, int nivel) 
			throws  Exception {
		Dao.begin();			
		Area a = daoarea.readAreaByNome(nome);
		if(a != null) {
			Dao.rollback();
			throw new Exception("Área já cadastrada!: " + nome);
		}
		
		a = new Area(nome, nivel);
		daoarea.create(a);		
		Dao.commit();
		return a;
	}
	
	
	public static Area apagarArea(String nome, int id) throws  Exception{
		Dao.begin();			
		Area a = daoarea.read(id);
		if(a == null)throw new Exception("Area não cadastrada!:" + nome);

		if(a.getLivros() != null){	
			ArrayList<Livro> livros = a.getLivros();
			for(Livro l : livros) {
				retirarLivroArea(a.getId(), l.getTitulo());
			}
		}
		
		if(a.getAutores() != null){
			ArrayList<Autor> autores = a.getAutores();
			for(Autor au : autores) {
				retirarAutorArea(a.getId(), au.getNome());
			}
		}
		daoarea.delete(a);		
		Dao.commit();
		return a;
	}
	

	public static Area consultarArea(int id) 
			throws  Exception {
		Dao.begin();			
		Area a = daoarea.read(id);
		if(a == null) {
			Dao.rollback();
			throw new Exception("Área não Encontrada!: ");
		}
		return a;
	}
	
	
	public static Area alterarArea(int id, String nome, int nivel) 
			throws  Exception {
		Dao.begin();			
		Area a= consultarArea(id);
		a.setNome(nome);
		a.setNivel(nivel);
		daoarea.update(a);		
		Dao.commit();
		return a;
	}
	
	public static List<Area> listarAreas() throws  Exception {
		Dao.begin();
		List<Area> areas = daoarea.readAll();
		if(areas == null) {
			throw new Exception("Nenhuma Area cadastrada!: ");
		}
		return areas;		
	}
	
	
	
	public static void inserirLivroArea(int id, String nome) throws  Exception {	

		Area a = daoarea.read(id);
		if(a == null) {
			Dao.rollback();
			throw new Exception("Área não cadastrada!: " + nome);
		}

		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		if(a.locLivro(nome) != null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") já pertence a area: " + a.getNome() );
		}

		a.addLivro(l);
		daoarea.update(a);		
		daolivro.update(l);			
		Dao.commit();
	}

	public static void retirarLivroArea(int id, String nome) throws  Exception {
		
		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		Area a = daoarea.read(id);
		if(a.locLivro(nome) == null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") não foi encontrado para esta area: " + a.getNome() );
		}

		a.delLivro(l);
		l.delArea(a);
		daoarea.update(a);
		daolivro.update(l);		// Cuidado
		Dao.commit();
	}
	
	
	
	public static void inserirAutorArea(int id, String nome) throws  Exception {
		
		Autor au = daoautor.readAutorByNome(nome);
		if(au == null) {
			Dao.rollback();
			throw new Exception("Autor não cadastrado!: " + nome);
		}

		
		Area a = daoarea.read(id);
		if(a == null) {
			Dao.rollback();
			throw new Exception("Área não cadastrada!: " + nome);
		}
		
		
		if(au.locArea(nome) != null) {
			Dao.rollback();
			throw new Exception("Este Área ("+nome+") já pertence ao autor: " + au.getNome() );
		}

		au.addAtuacao(a);
		daoautor.update(au);		
		//daolivro.update(l);			
		Dao.commit();
	}

	public static void retirarAutorArea(int id, String nome) throws  Exception {
					
		
		Autor au = daoautor.readAutorByNome(nome);
		if(au == null) {
			Dao.rollback();
			throw new Exception("Autor não cadastrado!: " + nome);
		}
		
		Area a = daoarea.read(id);
		if(a.locAutor(nome) == null) {
			Dao.rollback();
			throw new Exception("Este Autor ("+nome+") não foi encotrado para esta area: " + a.getNome() );
		}

		au.delAtuacao(a);
		a.delAutor(au);
		daoarea.update(a);
		daoautor.update(au);		// Cuidado
		Dao.commit();
	}
	
	
	
	/********************** Editora **********************/
	
	
	public static Editora cadastrarEditora(String nome, String site, String email, String rua, String cidade, String estado, String tel, String tel2) 
			throws  Exception {
		Dao.begin();			
		Editora e = daoeditora.readEditoraByNome(nome);
		if(e != null) {
			Dao.rollback();
			throw new Exception("Editora já cadastrada!: " + nome);
		}
		
		e = new Editora(nome, site, email, rua, cidade, estado);
		
		e.addTelefone(tel);
		e.addTelefone(tel2);
		daoeditora.create(e);		
		Dao.commit();
		return e;
	}
	
	
	public static Editora apagarEditora(int id, String nome) throws  Exception{
		Dao.begin();			
		Editora e = daoeditora.read(id);
		if(e == null)throw new Exception("Editora não cadastrada!:" + nome);

		if(e.getLivros() != null){
			
			ArrayList<Livro> livros = e.getLivros();
			for(Livro l : livros) {
				retirarLivroEditora(e.getId(), l.getTitulo());
			}
		}
		daoeditora.delete(e);		
		Dao.commit();
		return e;
	}
	
	public static List<Editora> listarEditoras() {
		List<Editora> editoras = daoeditora.readAll();
		return editoras;		
	}
	
	
	public static void inserirLivroEditora(int id, String nome) throws  Exception {
		

		Editora e = daoeditora.read(id);
		if(e == null) {
			Dao.rollback();
			throw new Exception("Editora não cadastrada!: " + nome);
		}

		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		if(e.locLivro(nome) != null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") já possui a Editora: " + e.getNome() );
		}

		e.addLivro(l);
		daoeditora.update(e);		
		daolivro.update(l);			
		Dao.commit();
	}

	public static void retirarLivroEditora(int id, String nome) throws  Exception {
				
		
		Livro l = daolivro.readLivroByNome(nome);
		if(l == null) {
			Dao.rollback();
			throw new Exception("Livro não cadastrado!: " + nome);
		}
		
		Editora e = daoeditora.read(id);
		if(e.locLivro(nome) == null) {
			Dao.rollback();
			throw new Exception("Este livro ("+nome+") não possui a Editora " + e.getNome() );
		}

		e.delLivro(l);
		l.delEditora(e);
		daoeditora.update(e);
		daolivro.update(l);		// Cuidado
		Dao.commit();
	}
	
	

	/********************** LIVRO**********************/	
	
	
	public static Livro cadastrarLivro(ArrayList<Autor> autores, ArrayList<Area> areas, Categoria categoria, 
			Editora editora, ArrayList<String> tags, String titulo, String resumo, 
			int paginas, int edicao, int ano, String informacoes, boolean status, BufferedImage bf, File pdf ) 
			throws  Exception {
	
			Livro l = daolivro.readLivroByNome(titulo);
			if(l != null) {
				Dao.rollback();
				throw new Exception("Livro já cadastrado!: " + titulo);
			}
			
			l = new Livro(titulo, resumo, paginas, edicao, ano, informacoes, status, bf, pdf);
				
			l.addCategoria(categoria);
			
			l.addEditora(editora);
			
			for(String t : tags)
				l.addTag(t);
			
			for(Area a : areas)
				l.addArea(a);
			
			for(Autor au: autores)
				l.addAutor(au);
				
			
			daolivro.create(l);		
			Dao.commit();
			
			return l;
	}
	
	
	public static Livro apagarLivro(int id) throws  Exception{
		Dao.begin();			
		Livro l = daolivro.read(id);
		if(l == null)throw new Exception("Livro não localizado!");
		
		if(l.getAutores() != null){
			ArrayList<Autor> autores = l.getAutores();
			for(Autor au : autores) {
				retirarLivroAutor(au.getId(), l.getTitulo());
			}
		}
		
		if(l.getAreas() != null){
			ArrayList<Area> areas = l.getAreas();
			for(Area a : areas) {
				retirarLivroArea(a.getId(), l.getTitulo());
			}
		}
		
		if(l.getCategoria() != null){
			Categoria c = l.getCategoria();
			retirarLivroCategoria(c.getId(), l.getTitulo());
			
		}
		
		if(l.getEditora() != null){
			Editora e = l.getEditora();
			retirarLivroEditora(e.getId(), l.getTitulo());
			
		}
		daolivro.delete(l);		
		Dao.commit();
		return l;
	}
	
	
	public static Livro getLivro(int id) {
		Livro livro = daolivro.read(id);
		return livro;		
	}
	
	
	public static List<Livro> ListarLivros() {
		List<Livro> livros = daolivro.readAll();
		return livros;		
	}
	
	
	public static List<Livro> procurarLivrosPorNome(String titulo) throws Exception {
		List<Livro> l  = daolivro.readLivrosByNome(titulo);
		if (l == null)
			throw new Exception("Nenhum livro encontrado para esta busca: "+titulo+"!");
		return l;		
	}
	
	
	public static List<Livro> procurarLivrosPorCategoria(String nome) {
		List<Livro> livros = daocategoria.readLivrosByCategoria(nome);
		return livros;		
	}
	
	public static List<Livro> procurarLivrosPorEditora(String nome) {
		List<Livro> livros = daoeditora.readLivrosByEditora(nome);
		return livros;		
	}
	

	public static List<Livro> procurarLivrosPorAutor(String nome) {
		List<Livro> livros = daoautor.readLivrosByAutor(nome);
		return livros;		
	}
	
	public static List<Livro> procurarLivrosPorAreas(String nome) {
		List<Livro> livros = daoarea.readLivrosByArea(nome);
		return livros;		
	}
	
	
	
	public static List<Area> procurarAreasPorAutor(String nome) {
		List<Area> areas = daoautor.readAreasByAutor(nome);
		return areas;		
	}

	
	public static Categoria procurarLivrosNaCategoria(String nome) throws Exception {
		Categoria categoria = daocategoria.readCategoriaByNome(nome);
		if (categoria == null)
			throw new Exception("Nenhum livro encontrado com o nome desta categoria: "+nome+"!");
		return categoria;		
	}
	
	
	public static Editora procurarLivrosNaEditora(String nome) throws Exception {
		Editora e = daoeditora.readEditoraByNome(nome);
		if (e == null)
			throw new Exception("Nenhum livro encontrado com o nome desta editora: "+nome+"!");
		return e;		
	}
	

	public static Autor procurarLivrosNoAutor(String nome)throws Exception {
		Autor au = daoautor.readAutorByNome(nome);
		if (au== null)
			throw new Exception("Nenhum livro encontrado com o nome deste autor: "+nome+"!");
		return au;		
	}
	
	public static Area procurarLivrosNaArea(String nome) throws Exception{
		Area  a = daoarea.readAreaByNome(nome);
		if (a == null)
			throw new Exception("Nenhum livro encontrado com o nome desta área: "+nome+"!");
		return a;		
	}
	
	

	
	
	
	
}
