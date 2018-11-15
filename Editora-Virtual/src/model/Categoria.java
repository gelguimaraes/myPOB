package model;

import java.util.ArrayList;

import dao.IdInterface;

public class Categoria implements IdInterface {
	private int id;
	private String nome;
	private ArrayList<Livro> livros = new ArrayList<>();
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void addLivro(Livro livro) {
		livros.add(livro);
	}
	
	public void delLivro(Livro livro) {
		livros.remove(livro);
	
	}
	public Livro locLivro(String nome) {
		for(Livro l : livros) {
			if (l.getTitulo().equals(nome))
				return l;
		}
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + " - " + nome;
	}
	
}
