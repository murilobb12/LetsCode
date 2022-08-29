package com.letscode.ecommerce.services;

import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodosClientes();

    boolean novoCliente(ClienteDto clienteDto);
    boolean atualizarCliente(Cliente cliente);
    boolean removerCliente(long id);



}
