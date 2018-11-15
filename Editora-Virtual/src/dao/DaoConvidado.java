package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Convidado;

public class DaoConvidado extends Dao<Convidado>{

	public Convidado readConvidadoByNome (String nome){	
	Query q = manager.query();
		q.constrain(Convidado.class);
	q.descend("nome").constrain(nome).like();
	List<Convidado> resultados = q.execute();
		if (resultados.size() > 0)
			return (Convidado) resultados.get(0);		else			return null;
	}
	
	
}
