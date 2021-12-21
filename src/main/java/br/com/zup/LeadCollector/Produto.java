package br.com.zup.LeadCollector;

import javax.persistence.*;

@Entity //entidade gera tabela no banco de dados
@Table (name = "produtos") //dá nome para tabela ou pode ser usado apra mapear uma tabela que já existe.
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)//esse nome será unico, somente um produto com mesmo nome
    private String nome;

    //Por padrão se não tem cosntrutor, já tenho um construtor vazio


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
