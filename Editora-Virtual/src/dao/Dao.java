/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import model.Administrador;
import model.Area;
import model.Autor;
import model.Categoria;
import model.Convidado;
import model.Editora;
import model.Livro;
import model.Usuario;



public abstract class Dao<T> implements DaoInterface<T> {
	protected static ObjectContainer manager;

	public static void open(){	
		if(manager == null){		
			abrirBancoLocal();
			//abrirBancoServidor();
			IdControl.registrarManager(manager); 		// eventos para gerenciar autonumeração de id
		}
	}
	public static void abrirBancoLocal(){		
		//new File("banco.db4o").delete();  //apagar o banco
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // 0,1,2,3...
		config.common().objectClass(Livro.class).cascadeOnDelete(true);
		config.common().objectClass(Livro.class).cascadeOnUpdate(true);
		config.common().objectClass(Livro.class).cascadeOnActivate(true);  
		config.common().objectClass(Usuario.class).cascadeOnDelete(true);
		config.common().objectClass(Usuario.class).cascadeOnUpdate(true);
		config.common().objectClass(Usuario.class).cascadeOnActivate(true);
		config.common().objectClass(Administrador.class).cascadeOnDelete(true);
		config.common().objectClass(Administrador.class).cascadeOnUpdate(true);
		config.common().objectClass(Administrador.class).cascadeOnActivate(true);
		config.common().objectClass(Area.class).cascadeOnDelete(true);
		config.common().objectClass(Area.class).cascadeOnUpdate(true);
		config.common().objectClass(Area.class).cascadeOnActivate(true);
		config.common().objectClass(Autor.class).cascadeOnDelete(true);
		config.common().objectClass(Autor.class).cascadeOnUpdate(true);
		config.common().objectClass(Autor.class).cascadeOnActivate(true);
		config.common().objectClass(Categoria.class).cascadeOnDelete(true);
		config.common().objectClass(Categoria.class).cascadeOnUpdate(true);
		config.common().objectClass(Categoria.class).cascadeOnActivate(true);
		config.common().objectClass(Convidado.class).cascadeOnDelete(true);
		config.common().objectClass(Convidado.class).cascadeOnUpdate(true);
		config.common().objectClass(Convidado.class).cascadeOnActivate(true);
		config.common().objectClass(Editora.class).cascadeOnDelete(true);
		config.common().objectClass(Editora.class).cascadeOnUpdate(true);
		config.common().objectClass(Editora.class).cascadeOnActivate(true);
		
		//indexacao 
		config.common().objectClass(Livro.class).objectField("id").indexed(true);
		config.common().objectClass(Livro.class).objectField("titulo").indexed(true);
		config.common().objectClass(Usuario.class).objectField("nome").indexed(true);
		config.common().objectClass(Autor.class).objectField("nome").indexed(true);
		
		manager = Db4oEmbedded.openFile(config, "editora.db4o");
	}

	public static void abrirBancoServidor(){
		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
		config.common().messageLevel(0);  
		config.common().objectClass(Livro.class).cascadeOnDelete(true);
		config.common().objectClass(Livro.class).cascadeOnUpdate(true);
		config.common().objectClass(Livro.class).cascadeOnActivate(true);  
		config.common().objectClass(Usuario.class).cascadeOnDelete(true);
		config.common().objectClass(Usuario.class).cascadeOnUpdate(true);
		config.common().objectClass(Usuario.class).cascadeOnActivate(true);
		config.common().objectClass(Administrador.class).cascadeOnDelete(true);
		config.common().objectClass(Administrador.class).cascadeOnUpdate(true);
		config.common().objectClass(Administrador.class).cascadeOnActivate(true);
		config.common().objectClass(Area.class).cascadeOnDelete(true);
		config.common().objectClass(Area.class).cascadeOnUpdate(true);
		config.common().objectClass(Area.class).cascadeOnActivate(true);
		config.common().objectClass(Autor.class).cascadeOnDelete(true);
		config.common().objectClass(Autor.class).cascadeOnUpdate(true);
		config.common().objectClass(Autor.class).cascadeOnActivate(true);
		config.common().objectClass(Categoria.class).cascadeOnDelete(true);
		config.common().objectClass(Categoria.class).cascadeOnUpdate(true);
		config.common().objectClass(Categoria.class).cascadeOnActivate(true);
		config.common().objectClass(Convidado.class).cascadeOnDelete(true);
		config.common().objectClass(Convidado.class).cascadeOnUpdate(true);
		config.common().objectClass(Convidado.class).cascadeOnActivate(true);
		config.common().objectClass(Editora.class).cascadeOnDelete(true);
		config.common().objectClass(Editora.class).cascadeOnUpdate(true);
		config.common().objectClass(Editora.class).cascadeOnActivate(true);
		
		//indexacao 
		config.common().objectClass(Livro.class).objectField("id").indexed(true);
		config.common().objectClass(Livro.class).objectField("titulo").indexed(true);
		config.common().objectClass(Usuario.class).objectField("nome").indexed(true);
		config.common().objectClass(Autor.class).objectField("nome").indexed(true);
		
		manager = Db4oClientServer.openClient(config,"127.0.0.1",34000,"gel","123");	
	}
	public static void close(){
		if(manager != null) {
			manager.close();
			manager = null;
		}
	}

	//----------CRUD-----------------------

	public void create(T obj){
		manager.store(obj);
	}
	
	@SuppressWarnings("unchecked")
	public T read(int id){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		q.descend("id").constrain(id);
		List<T> resultados = q.execute();
		if (resultados.size()>0)
			return (T) resultados.get(0);
		else
			return null;
	}

	public T update(T obj){
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj){
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}
	
	//--------transação---------------
	public static void begin(){}	
	public static void commit(){
		manager.commit();
	}
	
	public static void rollback(){
		manager.rollback();
	}
	
}