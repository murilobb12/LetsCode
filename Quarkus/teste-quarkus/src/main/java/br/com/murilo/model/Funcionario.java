package br.com.murilo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @NotNull(message = "Funcionário deve estar vinculado a um Departamento!")
    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Departamento departamentoId;


}
