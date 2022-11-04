package br.com.murilo.service;

import br.com.murilo.dto.FuncionarioDto;
import br.com.murilo.model.Funcionario;
import br.com.murilo.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FuncionarioService {

    @Inject
    FuncionarioRepository funcionarioRepository;


    public List<Funcionario> listarFuncionarios(){

        List<Funcionario> funcionarios = funcionarioRepository.listAll();

        return funcionarios;


    }

    @Transactional
    public Funcionario salvarFuncionario(FuncionarioDto funcionarioDto){

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setIdade(funcionarioDto.getIdade());
        funcionario.setDepartamentoId(funcionarioDto.getDepartamentoId());

        funcionarioRepository.persist(funcionario);

        return funcionario;

    }


}
