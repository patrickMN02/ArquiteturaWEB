package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.CategoriaProduto;
import com.example.demo.repository.CategotoriaProdutoRepository;
import com.example.demo.models.Produto;
import com.example.demo.repository.ProdutoRepository;

@SpringBootApplication
public class DemoApplication {
    
    @Bean
    public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository) {
    return args -> {
    produtoRepository.inserir(
    new Produto((long) 0, "teste",2000, "Veiculo"));
    produtoRepository.editar(
    new Produto((long)0, "teste2", 2050, "Brinquedo"));
    List<Produto> listaProdutos = produtoRepository.obterTodos();
    listaProdutos.forEach(System.out::println);
    produtoRepository.obterTodos();    
    produtoRepository.excluir(1);
    };
    }
    
    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
