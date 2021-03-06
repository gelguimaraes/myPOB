package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Autor extends Usuario {
	
	private String token;
	private byte[] imagem;
	private String cidade;
	private String estado;
	private String pais;
	private ArrayList<String> ocupacoes = new ArrayList<>();
	private ArrayList<String> telefones = new ArrayList<>();
	private ArrayList<Area> atuacoes = new ArrayList<>();
	private ArrayList<Livro> livros = new ArrayList<>();
	
	public Autor(String nome, String login, String senha, String email, String token, BufferedImage bf, String cidade,
			String estado, String pais) {
		super(nome, login, senha, email);
		this.token = token;
		this.setBufferedImage(bf);
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<String> getOcupacoes() {
		return ocupacoes;
	}

	public void addOcupacao(String ocupacao) {
		this.ocupacoes.add(ocupacao);
	}
	
	public void delOcupacao(String ocupacao) {
		this.ocupacoes.remove(ocupacao);
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void addTelefone(String telefone) {
		this.telefones.add(telefone);
	}
	
	public void delTelefone(String telefone) {
		this.telefones.remove(telefone);
	}

	
	
	public BufferedImage getBufferedImage() throws Exception{
		try {
			InputStream in = new ByteArrayInputStream(this.imagem);
			BufferedImage bf = ImageIO.read(in);
			return bf;
		} catch (IOException e) {
			throw new Exception("Leitura de arquivo inv�lida!");
		}
		
	}

	public void setBufferedImage(BufferedImage bf) {
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bf, "jpg", baos );		// tipo de gravacao
			baos.flush();
			baos.close();
			this.imagem = baos.toByteArray();		
		}
		catch(Exception e ){
			e.printStackTrace();
		}

	}
	public ArrayList<Area> getAtuacoes() {
		return atuacoes;
	}

	public void addAtuacao(Area atuacao) {
		this.atuacoes.add(atuacao);
		
		atuacao.addAutor(this);
	}
	
	public void delAtuacao(Area atuacao) {
		this.atuacoes.remove(atuacao);
		atuacao.delAutor(this);
	}
	
	public Area locArea(String nome) {
		for(Area a : atuacoes) {
			if (a.getNome().equals(nome))
				return a;
		}
		return null;
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public void delLivro(Livro livro) {
		this.livros.remove(livro);
	}
	public Livro locLivro(String nome) {
		for(Livro l : livros) {
			if (l.getTitulo().equals(nome))
				return l;
		}
		return null;
	}


	@Override
	public String toString() {
		return super.getId() + " - " + super.getNome();
	}
	
	
}
