package model;

import java.util.ArrayList;

import dao.IdInterface;

public class Editora implements IdInterface {
	
	private int id;
	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<String> telefones = new ArrayList<>();
	private String nome;
	private String site;
	private String email;
	private String rua;
	private String cidade;
	private String estado;
	
	
	public Editora(String nome, String site, String email, String rua, String cidade, String estado) {
		this.nome = nome;
		this.site = site;
		this.email = email;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
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
	
	
	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void addTelefone(String telefone) {
		this.telefones.add(telefone);
	}
	
	public void delTelefone(String telefone) {
		this.telefones.remove(telefone);
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
		return id + " - " + nome;
	}

}
