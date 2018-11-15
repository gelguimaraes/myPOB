package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Administrador;


public class DaoAdministrador extends Dao<Administrador> {
	public DaoAdministrador() {
		super();
	}	
	public Administrador readAdmByNome(String nome){	
		try{
			Query q = manager.createQuery("select a from Administrador a where a.nome= '" + nome +"'");
			return (Administrador) q.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
	
}