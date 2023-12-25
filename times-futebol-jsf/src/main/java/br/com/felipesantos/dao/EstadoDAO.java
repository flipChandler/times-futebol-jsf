package br.com.felipesantos.dao;

import java.io.Serializable;

import br.com.felipesantos.model.Estado;


public class EstadoDAO<T> extends DAOGenerico<Estado> implements Serializable {
	
	public EstadoDAO() {
		super();
		classePersistente = Estado.class;
	}
}
