package view;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.Fachada;
import model.Area;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;



public class Teste {
	protected static EntityManager manager;
	Categoria c1;
	Livro l1;
	Editora e1;
	Area a1, a2;
	Autor au1;
	public Teste(){
		
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("editora-virtual");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		cadastrar();
		System.out.println("fim do programa");
	}
		
		
	public void cadastrar() {
		Fachada.inicializar();
		
		/*c1 = new Categoria("Academico");
		manager.persist(c1);
		
		e1 = new Editora("Saraiva", "www.saraiva.com.br", "contato@saraiva.com", 
				"AV Paulista, 1000", "São Paulo", "SP");
		e1.addTelefone("(11)2500-3030");
		e1.addTelefone("(11)2500-3031");
		e1.addTelefone("(11)98700-6565");
		manager.persist(e1);
		
		a1 = new Area("Jornalismo", 1);
		manager.persist(a1);
		a2 = new Area("Jornalismo Investigativo", 2);
		manager.persist(a2);
		
		au1 = new Autor("José Guimarães", "joseguimaraes", "jose123", 
				"jguimaraes@hotmail.com", "a1b2c3", null, "Salvador", "Bahia", "Brasil");
		au1.addOcupacao("Jornalista");
		au1.addOcupacao("Escritor");
		au1.addOcupacao("Professor");
		
		au1.addAtuacao(a1);
		au1.addAtuacao(a2);
		
		au1.addTelefone("(71)4000-2030");
		au1.addTelefone("(71)4000-2031");
		au1.addTelefone("(71)98722-0000");
	
		manager.persist(au1);
		
		
		
		c1 = new Categoria("Comecial");
		manager.persist(c1);
		
		a1 = new Area("Saúde", 1);
		manager.persist(a1);
		a2 = new Area("Medicina Social", 2);
		manager.persist(a2);
		
		au1 = new Autor("Francisco Soares", "fsoares", "soares123", 
				"fsoares@hotmail.com", "999aa99aa", null, "João Pessoa", "PB", "Brasil");
		au1.addOcupacao("Médico");
		au1.addOcupacao("Escritor");
		
		au1.addAtuacao(a1);
		au1.addAtuacao(a2);
		
		au1.addTelefone("(83)3020-2030");
		au1.addTelefone("(83)98722-0000");
		
		l1 = new Livro("Medicina nas Favelas", "Resumo do Livro", 200, 1, 2010, "informações do livro", true, null, null);
		l1.addCategoria(c1);
		
		l1.addArea(a1);
		l1.addArea(a2);
		
		l1.addAutor(au1);
		
		l1.addTag("#Saude");
		l1.addTag("#Medicina");
		l1.addTag("#Sociedade");
	
		manager.persist(l1);
		manager.getTransaction().commit();*/
		
		try {
			Fachada.inserirLivroEditora(1, "Medicina nas Favelas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.getTransaction().commit();
	
	
	}
		
	


	
	public static void main (String[] args){
		new Teste();
	}

}
