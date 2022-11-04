package br.com.murilo.model;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Departamento departamentoId;


}
