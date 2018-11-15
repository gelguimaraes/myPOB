package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Usuario;

public class DaoUsuario extends Dao<Usuario> {


	public Usuario readyLogin(String email, String senha) {
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(email).and(q.descend("senha").constrain(senha));
		
		List<Usuario> resultados = q.execute();
		if (resultados.size() > 0)
			return (Usuario) resultados.get(0);
		else
			return null;
	}
	
	
	public Usuario readyUsuario(String nome, String email){	
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(email).and(q.descend("nome").constrain(nome));
		List<Usuario> resultados = q.execute();
		if (resultados.size() > 0)
			return (Usuario) resultados.get(0);
		else
			return null;
	}
	
	
}
