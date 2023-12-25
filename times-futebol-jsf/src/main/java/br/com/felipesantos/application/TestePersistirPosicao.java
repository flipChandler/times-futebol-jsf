package br.com.felipesantos.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.model.Posicao;

public class TestePersistirPosicao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolJsfPU");
        EntityManager em = emf.createEntityManager();
        
        Posicao posicao1 = new Posicao();
        posicao1.setNome("Goleiro");
        
        Posicao posicao2 = new Posicao();
        posicao2.setNome("Zagueiro");
        
        Posicao posicao3 = new Posicao();
        posicao3.setNome("Lateral Direito");
        
        Posicao posicao4 = new Posicao();
        posicao4.setNome("Lateral Esquerdo");
        
        Posicao posicao5 = new Posicao();
        posicao5.setNome("Volante");
        
        Posicao posicao6 = new Posicao();
        posicao6.setNome("Meio Campo");
        
        em.getTransaction().begin();
        em.persist(posicao1);
        em.persist(posicao2);
        em.persist(posicao3);
        em.persist(posicao4);
        em.persist(posicao5);
        em.persist(posicao6);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
