package br.com.zup.LeadCollector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/leads")
@RestControllerAdvice
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PutMapping //metodo que grava os dados no banco de dados
    public Lead cadastrarLead (@RequestBody @Valid Lead lead){
        return leadService.salvarLead(lead);
    }

    @GetMapping() //metodo que le dados no banco de dados
    public List<Lead>buscarProdutos(@RequestParam String nomeDoProduto){
        return leadService.buscasTodosPeloNomeProduto(nomeDoProduto);
    }
}
