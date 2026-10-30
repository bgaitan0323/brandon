package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toDto(Cliente cliente) {
        // valida que tenga datos
        if (cliente == null) {
            return null;
        }
        // convertir de cliente a clienteDto
        return ClienteDto.builder()
                // atributos de usuario
                .id(cliente.getId())
                .nombres(cliente.getNom())
                .apellidos(cliente.getApe())
                .direccion(cliente.getDir())
                .telefono(cliente.getTel())
                // atributos de cliente
                .tipCli(cliente.getTipoCliente())
                .puntos(cliente.getPuntos())
                .build();
    }

    @Override
    public Cliente toCliente(ClienteDto clienteDto) {
        // valida que tenga datos
        if (clienteDto == null) {
            return null;
        }
        // convertir de clienteDto a cliente
        return Cliente.builder()
                // atributos de usuario
                .id(clienteDto.getId())
                .nom(clienteDto.getNombres())
                .ape(clienteDto.getApellidos())
                .dir(clienteDto.getDireccion())
                .tel(clienteDto.getTelefono())
                // atributos de cliente
                .tipoCliente(clienteDto.getTipCli())
                .puntos(clienteDto.getPuntos())
                .build();
    }
}