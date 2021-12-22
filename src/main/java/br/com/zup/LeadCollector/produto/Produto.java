package br.com.zup.LeadCollector.produto;

import javax.persistence.*;
import java.util.Objects;

@Entity //entidade gera tabela no banco de dados
@Table (name = "produtos") //dá nome para tabela ou pode ser usado apra mapear uma tabela que já existe.
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)//esse nome será unico e não pode ser nula.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return nome.equals(produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
