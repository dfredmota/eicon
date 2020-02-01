package com.eicon.service;
import java.util.List;

public interface GenericService<T> {

	public List<T> all();

	public T getById(Long id);

	public T create(T entity) ;

	public T update(T entity);

	public void delete(Long id);

}