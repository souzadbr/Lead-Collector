package br.com.zup.LeadCollector.lead;

import br.com.zup.LeadCollector.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name= "leads")
public class Lead {

    @Id //email fica como chave primaria
    @Email
    private String email;
    @Column(columnDefinition = "VARCHAR(100)")
    @Size(min=3)
    private String nome;
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})//relacionando muitos leads para muitos produtos
    private List<Produto>produtosDeInteresse;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutosDeInteresse() {
        return produtosDeInteresse;
    }

    public void setProdutosDeInteresse(List<Produto> produtosDeInteresse) {
        this.produtosDeInteresse = produtosDeInteresse;
    }

    @RestController
    @RequestMapping("/leads")
    public static class LeadController {
        @Autowired
        private LeadService leadService;

        @PutMapping
        public Lead cadastrarLead(@RequestBody Lead lead){
           return leadService.salvarLead(lead);
        }
    }
}
