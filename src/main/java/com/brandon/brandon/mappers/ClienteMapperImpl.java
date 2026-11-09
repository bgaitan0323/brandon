package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.dtos.ClienteDtOResponse;
import com.brandon.brandon.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDtOResponse toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return ClienteDtOResponse.builder()
                // atributos de usuario (entidad: nom/ape/dir/tel -> dto: nombres/...)
                .id(cliente.getId())
                .nombres(cliente.getNom())
                .apellidos(cliente.getApe())
                .direccion(cliente.getDir())
                .telefono(cliente.getTel())
                // atributos de cliente
                .tipCli(cliente.getTipoCliente())
                .pts(cliente.getPuntos())
                .build();
    }

    @Override
    public Cliente toCliente(ClienteDto clienteDto) {
        if (clienteDto == null) {
            return null;
        }
        return Cliente.builder()
                // atributos de usuario
                .id(clienteDto.getId())
                .nom(clienteDto.getNombres())
                .ape(clienteDto.getApellidos())
                .dir(clienteDto.getDireccion())
                .tel(clienteDto.getTelefono())
                // atributos de cliente
                .tipoCliente(clienteDto.getTipCli())
                .tipoClienteNum(clienteDto.getTipCli())
                .puntos(clienteDto.getPuntos())
                .build();
    }
}