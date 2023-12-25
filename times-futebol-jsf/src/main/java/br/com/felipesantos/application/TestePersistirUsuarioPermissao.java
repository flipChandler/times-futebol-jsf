package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Permissao;
import br.com.felipesantos.model.Usuario;

public class TestePersistirUsuarioPermissao {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
		EntityManager em = emf.createEntityManager();
		
		String usuarioLogin = "capa-grossa";
		Usuario usuario = em.createQuery("from Usuario u where u.login like :login", Usuario.class)
				.setParameter("login", usuarioLogin)
				.getSingleResult();
		
		
		Permissao permissao1 = em.find(Permissao.class, "ADMINISTRADOR");
		Permissao permissao2 = em.find(Permissao.class, "USUARIO");
		
		usuario.getPermissoes().add(permissao1);
		usuario.getPermissoes().add(permissao2);
		
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
