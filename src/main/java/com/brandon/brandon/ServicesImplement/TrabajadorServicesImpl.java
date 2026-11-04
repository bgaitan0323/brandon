package com.brandon.brandon.ServicesImplement;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.mappers.TrabajadorMapper;
import com.brandon.brandon.models.Trabajador;
import com.brandon.brandon.repositoryes.TrabajadorRepository;
import com.brandon.brandon.services.TrabajadorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabajadorServicesImpl implements TrabajadorServices {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    // registrar un nuevo trabajador
    @Override
    public TrabajadorDto guardar(TrabajadorDto trabajadorDto) {
        Trabajador trabajador = trabajadorMapper.toEntity(trabajadorDto);
        Trabajador guardado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(guardado);
    }

    // listar todos los trabajadores
    @Override
    public List<TrabajadorDto> listarTodos() {
        return trabajadorRepository.findAll()
                .stream()
                .map(trabajadorMapper::toDto)
                .toList();
    }

    // consultar trabajador por id
    @Override
    public TrabajadorDto consultarPorId(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));
        return trabajadorMapper.toDto(trabajador);
    }

    // actualizar un trabajador
    @Override
    public TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto) {
        Trabajador existente = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));

        // atributos de usuario
        existente.setNom(trabajadorDto.getNombres());
        existente.setApe(trabajadorDto.getApellidos());
        existente.setDir(trabajadorDto.getDireccion());
        existente.setTel(trabajadorDto.getTelefono());
        // atributos de trabajador
        existente.setCargo(trabajadorDto.getCargo());
        existente.setSueldo(trabajadorDto.getSueldo());

        Trabajador actualizado = trabajadorRepository.save(existente);
        return trabajadorMapper.toDto(actualizado);
    }
}