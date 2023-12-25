package br.com.felipesantos.application;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Cidade;
import br.com.felipesantos.model.Pessoa;
import br.com.felipesantos.model.Time;
import br.com.felipesantos.model.Usuario;

public class TestePersistirTime {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		String nomeCidade = "São Paulo";
		Cidade cidade = em.createQuery("from Cidade c where c.nome like :nome", Cidade.class)
				.setParameter("nome", nomeCidade)
				.getSingleResult();
		
		String nomeTecnico = "Simaria";
		Pessoa tecnico = em.createQuery("from Pessoa p where p.nome like :nome", Pessoa.class)
				.setParameter("nome", nomeTecnico)
				.getSingleResult();
		
		String loginUsuario = "capa-grossa";
		Usuario usuario = em.createQuery("from Usuario u where u.login like :login", Usuario.class)
				.setParameter("login", loginUsuario)
				.getSingleResult();
		
		Time time = new Time();
		time.setNome("Corinthians");
		time.setHistoria("Time fundado em 1910 na cidade de São Paulo");
		time.setDataFundacao(new GregorianCalendar(1910, 9, 1));
		time.setCidade(cidade);
		time.setTecnico(tecnico);
		time.setUsuario(usuario);
		
		time.setNome("Corinthians");
		time.setNome("Corinthians");
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
