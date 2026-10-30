package com.brandon.brandon.services;

import java.util.List;

import com.brandon.brandon.dtos.UsuarioDto;

public interface UsuarioServices {

    UsuarioDto guardar(UsuarioDto usuarioDto);

    //Listar todos los usuarios
    List<UsuarioDto> listarTodos();

    // consultar usuario por id
    UsuarioDto buscarPorId(Long id);
}