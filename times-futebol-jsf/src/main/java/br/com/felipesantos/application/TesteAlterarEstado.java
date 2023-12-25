package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Estado;

public class TesteAlterarEstado {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Estado estado = em.find(Estado.class, 2);
		estado.setNome("Santa Catarina");
		estado.setUf("SC");
		
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
