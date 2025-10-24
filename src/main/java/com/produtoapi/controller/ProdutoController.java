package com.produtoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        produtoService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<Produto> findById(@PathVariable long id) {
        return produtoService.findById(id);
    }
    
}