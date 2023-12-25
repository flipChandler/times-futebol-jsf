package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Estado;

public class TestePersistirEstado {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setUf("SP");
		
		em.getTransaction().begin();
		em.persist(estado);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
