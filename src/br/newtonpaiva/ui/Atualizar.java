package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Fornecedor;
import br.newtonpaiva.dominio.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Atualizar {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();

        Fornecedor f = em.find(Fornecedor.class, 1);

        Produto p = new Produto();
        p.setNome("League of Legends");
        p.setFabricante("Riot");
        p.setDesconto(50.00);
        p.setDescricao("Pior jogo de todos os tempos");
        p.setPrecoCompra(100.00);
        p.setPrecoVenda(0.00);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(p);

        em.getTransaction().begin();
        f.setNome("Empresa Lixo");
        f.setCnpj("987654321");
        f.setTelefone("123456789");
        f.setProdutos(produtos);
        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}
