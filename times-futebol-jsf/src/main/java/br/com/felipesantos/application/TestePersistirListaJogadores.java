package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Jogador;
import br.com.felipesantos.model.Time;

public class TestePersistirListaJogadores {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		String nomeJogador = "Lucas";
		Jogador jogador = em.createQuery("from Jogador j where j.nome like :nome", Jogador.class)
				.setParameter("nome", nomeJogador)
				.getSingleResult();
		
		String nomeTime = "Corinthians";
		Time time = em.createQuery("from Time t where t.nome like :nome", Time.class)
				.setParameter("nome", nomeTime)
				.getSingleResult();
		
		time.adicionarJogador(jogador);
		
		em.getTransaction().begin();
		em.merge(time);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
