package br.ucsal.loja.to;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class ConsultaProdutoResponse {
	
	private Integer id;
	
	private String nome;
	
	private BigDecimal preco;
	
	private String descricao;
	
	private Timestamp cadastro;
	
	private BigInteger estoque;
	
	private List<FornecedorTO> fornecedores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getCadastro() {
		return cadastro;
	}

	public void setCadastro(Timestamp cadastro) {
		this.cadastro = cadastro;
	}

	public BigInteger getEstoque() {
		return estoque;
	}

	public void setEstoque(BigInteger estoque) {
		this.estoque = estoque;
	}

	public List<FornecedorTO> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorTO> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
