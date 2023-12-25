package br.com.felipesantos.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOGenerico<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<T> listaObjetos;
	private List<T> listaTodos;
	
	@Inject
	@PersistenceContext(unitName = "TimesFutebolJsfPU")
	protected EntityManager em;
	protected Class classePersistente;
	
	DAOGenerico() {
		
	}
	
	public List<T> getListaObjetos() {
		String jpql = "from " + classePersistente.getSimpleName();
		return em.createQuery(jpql).getResultList();
	}
	
	public List<T> getListaTodos() {
		String jpql = "from " + classePersistente.getSimpleName();
		return em.createQuery(jpql).getResultList();
	}
	
	public void persist(T obj) throws Exception {
		em.persist(obj);
	}
	
	public void merge(T obj) throws Exception {
		em.merge(obj);
	}
	
	public void remove(T obj) throws Exception {
		em.merge(obj);
		em.remove(obj);
	}
	
	public T findById(Object id) throws Exception {
		return (T) em.find(classePersistente, id);
	}
	
	public void setListaObjetos(List<T> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}
	
	public void setListaTodos(List<T> listaTodos) {
		this.listaTodos = listaTodos;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Class getClassePersistente() {
		return classePersistente;
	}
	
	public void setClassePersistente(Class classePersistente) {
		this.classePersistente = classePersistente;
	}	
}
