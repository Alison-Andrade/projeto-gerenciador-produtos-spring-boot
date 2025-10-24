package com.produtoapi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    public Produto salvar(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException("Não foi possível salvar o produto!");
        }

        return produtoRepository.save(produto);
    }

    public void deletar(long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }

    public Optional<Produto> findById(long id) {
        return produtoRepository.findById(id);
    }
}
