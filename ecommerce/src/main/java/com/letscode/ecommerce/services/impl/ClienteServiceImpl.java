package com.letscode.ecommerce.services.impl;

import com.letscode.ecommerce.dao.ClienteDao;
import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    @Override
    public boolean novoCliente(ClienteDto clienteDto) {
        try
        {
            Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(), clienteDto.getSexo(), clienteDto.getCpf());
            clienteDao.save(cliente);
            return true;
        }catch (Exception e){
            return false;
        }


    }


    @Override
    public boolean atualizarCliente(Cliente cliente) {

        try{
            clienteDao.save(cliente);
            return true;
        }catch (Exception e){
        return false;
        }
    }

    @Override
    public boolean removerCliente(long id) {
        clienteDao.deleteById(id);
        return true;
    }
}
