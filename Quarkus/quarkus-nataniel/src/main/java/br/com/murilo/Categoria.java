package br.com.murilo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import java.util.List;

@RequestScoped
@Entity
public class Categoria extends PanacheEntity {


    private String nome;

    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Categoria> listarCategorias(){
        return listAll();
    }


}