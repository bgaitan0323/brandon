package com.brandon.brandon.ServicesImplement;

import com.brandon.brandon.dtos.UsuarioDto;
import com.brandon.brandon.mappers.UsuarioMapper;
import com.brandon.brandon.models.Usuario;
import com.brandon.brandon.repositoryes.UsuarioRepository;
import com.brandon.brandon.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; 

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServicesImpl implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.convierteaEntidad(usuarioDto);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioDto(guardado);
    }
    @Override 
    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()     
                .map(usuarioMapper::toUsuarioDto)
                .toList();
}
@Override 

public UsuarioDto buscarPorId(Long id) {
    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
    return usuarioMapper.toUsuarioDto(usuario);
} 
}  