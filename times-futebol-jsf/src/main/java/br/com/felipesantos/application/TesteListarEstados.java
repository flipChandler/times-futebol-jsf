package br.com.felipesantos.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Estado;

public class TesteListarEstados {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		List<Estado> estados = em.createQuery("from Estado e order by e.id desc", Estado.class).getResultList();
		estados.forEach(estado -> System.out
				.println("ID: " + estado.getId() + ", Nome: " + estado.getNome() + ", UF: " + estado.getUf() + "\n==============================="));
		em.close();
		emf.close();
	}
}
