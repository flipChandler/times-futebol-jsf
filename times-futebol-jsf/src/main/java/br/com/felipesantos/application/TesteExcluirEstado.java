package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Estado;

public class TesteExcluirEstado {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Estado estado = em.find(Estado.class, 3);
		
		em.getTransaction().begin();
		em.remove(estado);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
