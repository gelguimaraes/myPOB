package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Categoria;

public class DaoCategoria extends Dao<Categoria> {

	
	public DaoCategoria() {
		super();
	}
	
	public Categoria readCategoriaByNome (String nome){	
		
		try{
			Query q = manager.createQuery("select c from Categoria c where c.nome like '" + nome +"'");
			return (Categoria) q.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
	
	
	/*public List<Livro> readLivrosByCategoria (String nome){	
		Query q = manager.query();
		q.constrain(Categoria.class);
		q.descend("nome").constrain(nome).like();
		List <List<Livro>> resultados = q.descend("livros").execute();
		if (resultados.size() > 0)
			return  resultados.get(0);
		else
			return null;
	}*/

		
}
