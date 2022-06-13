package br.ucsal.loja.persistence.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.ucsal.loja.exception.BusinessException;
import br.ucsal.loja.to.FornecedorTO;

@Component
public class FornecedorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<FornecedorTO> obterListaFornecedoresPeloIdProduto(Integer idProduto) throws BusinessException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT FO.nome, FO.cnpj, FO.email, FO.telefone ");
		sql.append("FROM PRODUTO_FORNECEDOR PR_FO ");
		sql.append("INNER JOIN PRODUTO PR ON PR.COD_PRODUTO = PR_FO.COD_PRODUTO ");
		sql.append("INNER JOIN FORNECEDOR FO ON FO.COD_FORNECEDOR = PR_FO.COD_FORNECEDOR ");
		sql.append("WHERE PR.COD_PRODUTO = ?1 ");
		
		List<FornecedorTO> retorno = entityManager.createNativeQuery(sql.toString())
												  .setParameter(1, idProduto)
												  .unwrap(NativeQuery.class)
												  .setResultTransformer(Transformers.aliasToBean(FornecedorTO.class))
												  .getResultList();
		
		
		if(Objects.nonNull(retorno) && !retorno.isEmpty()) {
			return retorno;
		}
		
		throw new BusinessException("Fornecedor não encontrado!", HttpStatus.NOT_FOUND);
		
	}
	
	@SuppressWarnings("deprecation")
	public List<FornecedorTO> obterFornecedores(String nome) throws BusinessException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT FO.nome, FO.cnpj, FO.email, FO.telefone ");
		sql.append("FROM FORNECEDOR WHERE 1=1 ");
		if(Objects.nonNull(nome) && !nome.isEmpty()) {
			sql.append("AND FO.nome LIKE ?1");
		}
		
		List<FornecedorTO> retorno = null;
		
		if(Objects.nonNull(nome) && !nome.isEmpty()) {
			entityManager.createNativeQuery(sql.toString())
			  			 .unwrap(NativeQuery.class)
			  			 .setResultTransformer(Transformers.aliasToBean(FornecedorTO.class))
			  			 .getResultList();
			
		} else {
			entityManager.createNativeQuery(sql.toString())
						 .setParameter(1, "%" + nome.trim() + "%")
						 .unwrap(NativeQuery.class)
						 .setResultTransformer(Transformers.aliasToBean(FornecedorTO.class))
						 .getResultList();
		}
		
		if(Objects.nonNull(retorno) && !retorno.isEmpty()) {
			return retorno;
		}

		throw new BusinessException("Fornecedor não encontrado!", HttpStatus.NOT_FOUND);
	}
	
}
