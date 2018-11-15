package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Area;
import model.Autor;
import model.Livro;


public class DaoArea extends Dao<Area> {

	
	public Area readAreaByNome (String nome){	
		Query q = manager.query();
		q.constrain(Area.class);
		q.descend("nome").constrain(nome).like();
		List<Area> resultados = q.execute();
		if (resultados.size() > 0)
			return (Area) resultados.get(0);
		else
			return null;
	}
	
	
	public List<Livro> readLivrosByArea (String nome){	
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
	
}
