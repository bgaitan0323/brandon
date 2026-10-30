package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.models.Cliente;

public interface ClienteMapper {

    ClienteDto toDto(Cliente cliente);

    Cliente toCliente(ClienteDto clienteDto);
}