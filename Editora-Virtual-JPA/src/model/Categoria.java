package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=4, nullable=false, name="ID")
	private int id;
	
	@Column(length=100, nullable=false, name="NOME_CATEGORIA")
	private String nome;
	

	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL, fetch=FetchType.LAZY)       				
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	
	
	public Categoria (){}
	
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
