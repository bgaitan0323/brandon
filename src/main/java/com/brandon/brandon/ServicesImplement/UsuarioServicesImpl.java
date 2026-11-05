package com.brandon.brandon.ServicesImplement;

import com.brandon.brandon.dtos.UsuarioDto;
import com.brandon.brandon.mappers.UsuarioMapper;
import com.brandon.brandon.models.Usuario;
import com.brandon.brandon.repositoryes.UsuarioRepository;
import com.brandon.brandon.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
         //  buscar usuario por id
@Override 

public UsuarioDto buscarPorId(Long id) {
    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
    return usuarioMapper.toUsuarioDto(usuario);
}   

        // eliminar un usuario
    @Override
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    
} 
@Override
public UsuarioDto actualizar(Long id, UsuarioDto usuarioDto) {
    Usuario existente = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuario no encontrado con id " + id));

    existente.setNom(usuarioDto.getNombres());
    existente.setApe(usuarioDto.getApellidos());
    existente.setDir(usuarioDto.getDireccion());
    existente.setTel(usuarioDto.getTelefono());

    return usuarioMapper.toUsuarioDto(usuarioRepository.save(existente));
}
}