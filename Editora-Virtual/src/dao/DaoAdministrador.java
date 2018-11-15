package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Administrador;


public class DaoAdministrador extends Dao<Administrador> {


	public Administrador readAdmByNome(String nome){	
		Query q = manager.query();
		q.constrain(Administrador.class);
		q.descend("nome").constrain(nome);
		List<Administrador> resultados = q.execute();
		if (resultados.size() > 0)
			return (Administrador) resultados;
		else
			return null;
	}
	
}
