package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Area;
import model.Autor;
import model.Livro;


public class DaoAutor extends Dao<Autor> {

	public Autor readAutorByNome(String nome){	
		Query q = manager.query();
		q.constrain(Autor.class);
		q.descend("nome").constrain(nome).like();
		List<Autor> resultados = q.execute();
		if (resultados.size() > 0)
			return (Autor) resultados.get(0);
		else
			return null;
	}

	public List<Livro> readLivrosByAutor(String nome){	
		Query q = manager.query();
		q.constrain(Autor.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Area> readAreasByAutor(String nome){	
		Query q = manager.query();
		q.constrain(Autor.class);
		q.descend("nome").constrain(nome).like();
		List<List<Area>> resultados = q.descend("atuacoes").execute();
		if (resultados.size() > 0)
			return  resultados.get(0);
		else
			return null;
	}
		
}
