package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity 
public class Editora {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=4, nullable=false, name="ID_EDITORA")
	private int id;
	
	
	@OneToMany(mappedBy="editora", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "EDITORA_TELEFONES", joinColumns=@JoinColumn(name = "FK_EDITORA_ID", referencedColumnName = "ID_EDITORA")) 
	@Column(length=50, nullable=true, name="TELEFONES")
	private ArrayList<String> telefones = new ArrayList<String>();
	
	private String nome;
	private String site;
	private String email;
	private String rua;
	private String cidade;
	private String estado;
	
	public Editora(){}
	
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
