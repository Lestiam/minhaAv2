package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Excluir {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();

        Fornecedor f = em.find(Fornecedor.class, 1);

        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}
