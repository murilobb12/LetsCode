package br.com.murilo.service;

import br.com.murilo.dto.FuncionarioDto;
import br.com.murilo.model.Departamento;
import br.com.murilo.model.Funcionario;
import br.com.murilo.repository.DepartamentoRepository;
import br.com.murilo.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FuncionarioService {

    @Inject
    DepartamentoRepository departamentoRepository;

    @Inject
    FuncionarioRepository funcionarioRepository;


    public List<Funcionario> listarFuncionarios(){

        return funcionarioRepository.listAll();


    }

    @Transactional
    public Funcionario salvarFuncionario(FuncionarioDto funcionarioDto){



        Funcionario funcionario = new Funcionario();

        Departamento byId = departamentoRepository.findById(funcionarioDto.getDepartamentoId());


        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setIdade(funcionarioDto.getIdade());
        funcionario.setDepartamentoId(byId);

        funcionarioRepository.persist(funcionario);

        return funcionario;

    }


}
