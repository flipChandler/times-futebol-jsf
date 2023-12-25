package br.com.felipesantos.application;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Jogador;
import br.com.felipesantos.model.Posicao;
import br.com.felipesantos.model.Time;

public class TestePersistirJogador {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Jogador jogador = new Jogador();
		jogador.setNome("Lucas");
		jogador.setAltura(1.84);
		jogador.setPeso(80.500);
		jogador.setCpf("533.396.674-54");
		jogador.setDataNascimento(Calendar.getInstance());
		jogador.setPosicao(em.find(Posicao.class, 1));
		jogador.setTime(em.find(Time.class, 1));
		
		em.getTransaction().begin();
		em.persist(jogador);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
