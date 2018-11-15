package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Area {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=4, nullable=false, name="ID_AREA")
	private int id;
	
	@ManyToMany(mappedBy="areas", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	
	@ManyToMany(mappedBy="atuacoes", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	
	private String nome;
	private int nivel;

	public Area() {}
	
	public Area(String nome, int nivel) {
		this.nome = nome;
		this.nivel = nivel;
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
	
	
	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
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
	
	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void addAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	public void delAutor(Autor autor) {
		this.autores.remove(autor);
	
	}
	
	public Autor locAutor(String nome) {
		for(Autor a : autores) {
			if (a.getNome().equals(nome))
				return a;
		}
		return null;
	}

	@Override
	public String toString() {
		return  id + " - " + nome + " | Nível - " + nivel;
	}
	
	
	
}
