package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.UsuarioDto;
import com.brandon.brandon.models.Usuario;

public interface UsuarioMapper {

    UsuarioDto toUsuarioDto(Usuario usuario);

    Usuario convierteaEntidad(UsuarioDto usuarioDto);
}