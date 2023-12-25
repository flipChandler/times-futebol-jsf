package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Usuario;

public class TestePersistirUsuario {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("capa-grossa");
		usuario.setSenha("12345");
		usuario.setNome("Jorgenil");
		usuario.setEmail("jorgenil@hotmail.com");
		usuario.setAtivo(true);	
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
