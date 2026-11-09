package com.brandon.brandon.services;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.dtos.ClienteDtOResponse;

import java.util.List;

public interface ClienteServices {
    ClienteDtOResponse guardar(ClienteDto clienteDto);
    List<ClienteDtOResponse> listarTodos();
    ClienteDtOResponse consultarPorId(Long id);
    ClienteDtOResponse actualizar(Long id, ClienteDto clienteDto);
    void eliminar(Long id);
}