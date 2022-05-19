package com.aelion.game.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<T> { // T => Type générique
	public T add(T entity) throws SQLException;
	public Optional<T> find(int id) throws SQLException;
	public List<T> findAll() throws SQLException;
}
