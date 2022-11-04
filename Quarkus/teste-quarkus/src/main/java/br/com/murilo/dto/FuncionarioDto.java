package br.com.murilo.dto;

import br.com.murilo.model.Departamento;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FuncionarioDto {


    @NotBlank
    private String nome;
    @NotNull
    private Integer idade;

    private Departamento departamentoId;


}
