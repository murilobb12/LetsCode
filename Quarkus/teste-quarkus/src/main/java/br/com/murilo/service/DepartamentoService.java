package br.com.murilo.service;

import br.com.murilo.dto.DepartamentoDto;
import br.com.murilo.model.Departamento;
import br.com.murilo.repository.DepartamentoRepository;
import io.quarkus.logging.Log;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartamentoService {


    @Inject
    DepartamentoRepository departamentoRepository;


    public List<Departamento> listarDep(){

        return departamentoRepository.listAll();

    }


    public List<Departamento> salvarDep(List<DepartamentoDto> departamentoDto) {

        List<Departamento> departamentoList = new ArrayList<>();

        for (DepartamentoDto dto : departamentoDto) {

            departamentoList.add(new Departamento(dto.getNome()));

        }

        departamentoRepository.persist(departamentoList);

        return departamentoList;

    }

    public Optional<Departamento> listDepById(Long id){

        Optional<Departamento> depByIdOptional = departamentoRepository.findByIdOptional(id);

        if (depByIdOptional.isPresent()){
        return depByIdOptional;
        }
        throw new InvalidParameterException("ID não encontrado na nossa base");
    }

    public Departamento atualizarDep(Long id, DepartamentoDto departamentoDto) {

        Departamento depById = departamentoRepository.findById(id);

        depById.setNome(departamentoDto.getNome());

        departamentoRepository.persist(depById);

        return depById;

    }


    public void deletarDep(Long id) {

        Optional<Departamento> depByIdOptional = departamentoRepository.findByIdOptional(id);
        Departamento departamento = depByIdOptional.orElseThrow(NotFoundException::new);

        departamentoRepository.delete(departamento);

    }
}
