package br.com.murilo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity //Representar que essa classe é uma tabela
public class Usuario extends PanacheEntityBase {


    @Id //Esse atributo é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esse atributo é gerado automaticamente, de maneira identity
    private Long id;

    @NotEmpty //Não deixa que esse campo quando seja inserido ou alterado seja nulo ou vazio.
    private String nome;

    @NotNull //Não deixa que esse campo quando seja inserido ou alterado seja nulo ou vazio.
    private String cpf;

    @NotNull //Não deixa que esse campo quando seja inserido ou alterado seja nulo ou vazio.
    private String username;

    @NotNull //Não deixa que esse campo quando seja inserido ou alterado seja nulo ou vazio.
     private String password;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
