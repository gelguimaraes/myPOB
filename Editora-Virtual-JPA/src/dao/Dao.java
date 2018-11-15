package dao;


import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class Dao<T> implements DaoInterface<T> {
	protected static EntityManager manager;
	protected static EntityManagerFactory factory;

	public Dao(){}

	public static void open(){
		if(manager==null){		
			HashMap<String,String> properties = new HashMap<String, String>();		
			factory = Persistence.createEntityManagerFactory("editora-virtual", properties);
			manager = factory.createEntityManager();
		}
	}
	public static void close(){
		if(manager != null) {
			manager.close();
			factory.close();
		}
	}
	public void create(T obj){
		manager.persist(obj);
	}
	@SuppressWarnings("unchecked")
	public T read(Object chave){	// localizar pela chave primaria
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chave);
	}
	public T update(T obj){
		return manager.merge(obj);
	}
	public void delete(T obj) {
		manager.remove(obj);
	}


	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}

	//----------------------- TRANSAÇÃO   ----------------------
	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvaziar o cache de objetos
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}

}
