package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto editar(Produto produto){
    entityManager.merge(produto);
    return produto;
    }

    @Transactional
    public Produto inserir(Produto produto){
    entityManager.merge(produto);
    return produto;
    }

    @Transactional
    public void excluir(Produto produto){
    entityManager.remove(produto);
    }

    @Transactional
    public void excluir(int id){
    excluir(entityManager.find(Produto.class, id));
    }

    @Transactional(readOnly = true)
    public List<Produto> obterTodos() {
    return entityManager.createQuery("from Produto", Produto.class).getResultList();
}

    @Transactional(readOnly = true)
    public List<Produto> obterPorNome(String nome){
    String jpql = " select p from Produto p where p.nome like :nome";
    TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
    query.setParameter("nome", "%" + nome + "%");
    return query.getResultList();
    }


}

