package br.com.felipesantos.application;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Pessoa;

public class TestePersistirPessoa {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Simaria");
		pessoa.setDataNascimento(Calendar.getInstance());
		pessoa.setCpf("346.527.355-96");
		
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
