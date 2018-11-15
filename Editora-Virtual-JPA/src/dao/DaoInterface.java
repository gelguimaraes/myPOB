package dao;

import java.util.List;

public interface DaoInterface<T> {
	public void create(T obj);
	public T read(Object chave);
	public T update(T obj);
	public void delete(T obj) ;
	public List<T> readAll();
}