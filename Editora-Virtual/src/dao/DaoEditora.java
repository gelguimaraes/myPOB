package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Editora;
import model.Livro;

public class DaoEditora extends Dao<Editora> {


	public Editora readEditoraByNome (String nome){	
		Query q = manager.query();
		q.constrain(Editora.class);
		q.descend("nome").constrain(nome).like();
		List<Editora> resultados = q.execute();
		if (resultados.size() > 0)
			return  (Editora) resultados.get(0);
		else
			return null;
	}
	
	public List<Livro> readLivrosByEditora (String nome){	
		Query q = manager.query();
		q.constrain(Editora.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
}
