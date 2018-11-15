package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Categoria;
import model.Livro;

public class DaoCategoria extends Dao<Categoria> {

	public Categoria readCategoriaByNome (String nome){	
		Query q = manager.query();
		q.constrain(Categoria.class);
		q.descend("nome").constrain(nome).like();
		List<Categoria> resultados = q.execute();
		if (resultados.size() > 0)
			return (Categoria)resultados.get(0);
		else
			return null;
	}
	
	
	public List<Livro> readLivrosByCategoria (String nome){	
		Query q = manager.query();
		q.constrain(Categoria.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return  resultados.get(0);
		else
			return null;
	}

		
}
