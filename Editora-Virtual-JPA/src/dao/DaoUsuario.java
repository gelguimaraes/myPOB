package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Usuario;

public class DaoUsuario extends Dao<Usuario> {


	public Usuario readyLogin(String email, String senha) {
		
		
		try{
			Query q = manager.createQuery("select u from Usuario u where u.email='" 
					+ email + "and u.senha=" + senha + "'");
			 return (Usuario) q.getResultList();
			 
		}catch(NoResultException e){		
			return null;
		}
		
	}
	
	
	public Usuario readyUsuario(String nome, String email){	
		try{
			Query q = manager.createQuery("select u from Usuario u where u.email='" 
					+ email + "and u.email=" + email + "'");
			 return (Usuario) q.getResultList();
			 
		}catch(NoResultException e){		
			return null;
		}
	}
	
	
}
