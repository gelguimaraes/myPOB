package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Administrador;
import model.Area;
import model.Autor;
import model.Livro;


public class DaoArea extends Dao<Area> {
	
	public DaoArea() {
		super();
	}

	public Area readAreaByNome (String nome){
		
		try{	
			Query q = manager.createQuery("select a from Area a where a.nome='" + nome +"'");
			return (Area) q.getSingleResult();
	
		}catch(NoResultException e){		
			return null;
		}

	}
	
	
/*	public List<Livro> readLivrosByArea (String nome){	
		Query q = manager.query();
		q.constrain(Area.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	public List<Autor> readAutoresByArea (String nome){	
		Query q = manager.query();
		q.constrain(Area.class);
		q.descend("nome").constrain(nome).like();
		List<Autor> resultados = q.descend("nome").execute();
		if (resultados.size() > 0)
			return resultados;
		else
			return null;
	}
	*/
}
