package br.com.zup.LeadCollector.lead;


import br.com.zup.LeadCollector.produto.Produto;
import br.com.zup.LeadCollector.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    private LeadRepository leadRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public LeadService(LeadRepository leadRepository, ProdutoRepository produtoRepository) {
        this.leadRepository = leadRepository;
        this.produtoRepository = produtoRepository;
    }

    public Lead salvarLead(Lead lead) {
        List<Produto>produtos = buscarProdutos(lead.getProdutosDeInteresse());
        //optional é uma caixinha que pode ter ou não um lead dentro ou null.
        Optional<Lead>leadOptional = leadRepository.findById(lead.getEmail()); //se ele resgatar esse lead
        if(leadOptional.isPresent()){
            Lead leadDoBanco = leadOptional.get();
            for (Produto produto : leadDoBanco.getProdutosDeInteresse()){
                if(!leadDoBanco.getProdutosDeInteresse().contains(produto)){
                    leadDoBanco.getProdutosDeInteresse().add(produto);
                }
            }
            return leadRepository.save(leadDoBanco);
        }
        lead.setProdutosDeInteresse(produtos);
        return leadRepository.save(lead);
    }

    public List<Produto> buscarProdutos(List<Produto> produtos) {
        List<Produto> listaAtualizada = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produtoRepository.existsByNome(produto.getNome())) {
                listaAtualizada.add(produtoRepository.findByNome(produto.getNome()));
            }else {
                listaAtualizada.add(produto);
            }
        }

        return listaAtualizada;
    }

    public List<Lead>buscasTodosPeloNomeProduto(String nomeDoProduto){
        return leadRepository.findAllByProdutoDeInteresseNome(nomeDoProduto);
    }


}
