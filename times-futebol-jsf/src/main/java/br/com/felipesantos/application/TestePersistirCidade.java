package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Cidade;
import br.com.felipesantos.model.Estado;

public class TestePersistirCidade {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		String nomeEstado = "São Paulo";
		Estado estado = em.createQuery("from Estado e where e.nome like :nome", Estado.class)
				.setParameter("nome", nomeEstado)
				.getSingleResult();
		
		Cidade cidade = new Cidade();
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);
		
		em.getTransaction().begin();
		em.persist(cidade);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
