package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Permissao;

public class TestePersistirPermissao {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		Permissao permissao1 = new Permissao();
		permissao1.setNome("ADMINISTRADOR");
		permissao1.setDescricao("Permissão para administradores");
		
		Permissao permissao2 = new Permissao();
		permissao2.setNome("USUARIO");
		permissao2.setDescricao("Permissão para usuários comuns");
		
		em.getTransaction().begin();
		em.persist(permissao1);
		em.persist(permissao2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
