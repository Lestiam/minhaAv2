package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Fornecedor;
import br.newtonpaiva.dominio.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Criar {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Produto p = new Produto();
        p.setNome("League of Legends");
        p.setFabricante("Riot");
        p.setDesconto(50.00);
        p.setDescricao("Pior jogo de todos os tempos");
        p.setPrecoCompra(100.00);
        p.setPrecoVenda(0.01);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(p);

        Fornecedor f = new Fornecedor();
        f.setNome("Riot");
        f.setCnpj("123456789");
        f.setTelefone("992962037");
        f.setProdutos(produtos);

        em.persist(f);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
