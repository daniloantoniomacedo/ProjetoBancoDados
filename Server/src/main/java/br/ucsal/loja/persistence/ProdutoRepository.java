package br.ucsal.loja.persistence;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, BigInteger> {
}
