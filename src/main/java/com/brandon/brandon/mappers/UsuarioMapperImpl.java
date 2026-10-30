package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.UsuarioDto;
import com.brandon.brandon.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nombres(usuario.getNom())
                .apellidos(usuario.getApe())
                .direccion(usuario.getDir())
                .telefono(usuario.getTel())
                .build();
    }

    @Override
    public Usuario convierteaEntidad(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        return Usuario.builder()
                .id(usuarioDto.getId())
                .nom(usuarioDto.getNombres())
                .ape(usuarioDto.getApellidos())
                .dir(usuarioDto.getDireccion())
                .tel(usuarioDto.getTelefono())
                .build();
    }
}