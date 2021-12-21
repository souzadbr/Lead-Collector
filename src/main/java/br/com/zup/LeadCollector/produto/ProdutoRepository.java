package br.com.zup.LeadCollector.produto;

import org.springframework.data.repository.CrudRepository;
//Essa interface faz ligação com o banco de dados -  Produto e sua chave primaria no <>

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
    boolean existByNome(String nome); //vai verificar se o produto já existe cadastrado no banco de dados e retorna
    // sim ou não
}
