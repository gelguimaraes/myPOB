package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Editora;

public class DaoEditora extends Dao<Editora> {

	public DaoEditora() {
		super();
	}

	public Editora readEditoraByNome (String nome){	
		
		try{
			Query q = manager.createQuery("select e from Editora e where e.nome='" + nome +"'");
			return (Editora) q.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
		
	}
	
	/* public List<Livro> readLivrosByEditora (String nome){	
		Query q = manager.query();
		q.constrain(Editora.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}*/
	
}
