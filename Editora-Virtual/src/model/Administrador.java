package model;



public class Administrador extends Usuario{

	private String token;

	public Administrador(String nome, String login, String senha, String email, String token) {
		super(nome, login, senha, email);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
