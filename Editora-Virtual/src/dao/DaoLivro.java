package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Area;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

public class DaoLivro extends Dao<Livro> {

	public Livro readLivroByNome (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo);
		List<Livro> resultados = q.execute();
		if (resultados.size() > 0)
			return (Livro)resultados.get(0);
		else
			return null;
	}
	public List<Livro> readLivrosByNome (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo).like();
		List<Livro> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados;
		else
			return null;
	}

	
	public List<Area> readAreasByLivro (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo).like();
		List<Area> resultados = q.descend("areas").execute();
		if (resultados.size() > 0)
			return resultados;
		else
			return null;
	}
	
	public Categoria readCategoriaByLivro (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo).like();
		List<Categoria> resultados = q.descend("categoria").execute();
		if (resultados.size() > 0)
			return  resultados.get(0);
		else
			return null;
	}
	
	public Editora readEditoraByLivro (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo).like();
		List<Editora> resultados = q.descend("editora").execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Autor> readAutoresByLivro (String titulo){	
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain(titulo).like();
		List<Autor> resultados = q.descend("autores").execute();
		if (resultados.size() > 0)
			return resultados;
		else
			return null;
	}
	
	
}
