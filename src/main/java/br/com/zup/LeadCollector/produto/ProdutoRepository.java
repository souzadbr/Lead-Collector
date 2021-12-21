package br.com.zup.LeadCollector.produto;

import org.springframework.data.repository.CrudRepository;
//Essa interface faz ligação com o banco de dados -  Produto e sua chave primaria no <>
public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
}
