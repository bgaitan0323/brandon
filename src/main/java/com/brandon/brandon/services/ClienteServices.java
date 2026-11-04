package com.brandon.brandon.services;

import com.brandon.brandon.dtos.ClienteDto;
import java.util.List;

public interface ClienteServices {

    // registrar un nuevo cliente
    ClienteDto guardar(ClienteDto clienteDto);

    // listar todos los clientes
    List<ClienteDto> listarTodos();

    // consultar cliente por id
    ClienteDto consultarPorId(Long id);

    // actualizar un cliente
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

}