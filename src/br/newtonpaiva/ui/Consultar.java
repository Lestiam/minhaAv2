package br.newtonpaiva.ui;


import br.newtonpaiva.dominio.Fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consultar {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();

        Fornecedor f = em.find(Fornecedor.class, 1);

        System.out.println(f);

        em.close();
        factory.close();
    }
}
