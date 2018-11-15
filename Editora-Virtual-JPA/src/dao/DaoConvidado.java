package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Convidado;


public class DaoConvidado extends Dao<Convidado>{

	public DaoConvidado(){
		super();
	}
	
	public Convidado readConvidadoByNome (String nome){	
		try{
			Query q = manager.createQuery("select c from Convidado c where c.nome like '" + nome +"'");
			return (Convidado) q.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	
	}
}
