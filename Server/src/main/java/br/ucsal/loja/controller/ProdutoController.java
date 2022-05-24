package br.ucsal.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.loja.model.Produto;
import br.ucsal.loja.persistence.ProdutoRepository;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> obterTodosProdutos(){
		return produtoRepository.findAll();
	}

}
