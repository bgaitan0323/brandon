package com.brandon.brandon.ServicesImplement;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.dtos.TrabajadorDtoResponse;
import com.brandon.brandon.mappers.TrabajadorMapper;
import com.brandon.brandon.models.TiposCargo;
import com.brandon.brandon.models.Trabajador;
import com.brandon.brandon.repositoryes.TiposCargoRepository;
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
    private final TiposCargoRepository tiposCargoRepository;

    // registrar un nuevo trabajador
    @Override
    public TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto) {
        Trabajador trabajador = trabajadorMapper.toEntity(trabajadorDto);
        trabajador.setTiposCargo(buscarCargo(trabajadorDto.getTipoCargoId()));
        Trabajador guardado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(guardado);
    }

    // listar todos los trabajadores
    @Override
    public List<TrabajadorDtoResponse> listarTodos() {
        return trabajadorRepository.findAll()
                .stream()
                .map(trabajadorMapper::toDto)
                .toList();
    }

    // consultar trabajador por id
    @Override
    public TrabajadorDtoResponse consultarPorId(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));
        return trabajadorMapper.toDto(trabajador);
    }

    // actualizar un trabajador
    @Override
    public TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto) {
        Trabajador existente = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));

        // atributos de usuario
        existente.setNom(trabajadorDto.getNombres());
        existente.setApe(trabajadorDto.getApellidos());
        existente.setDir(trabajadorDto.getDireccion());
        existente.setTel(trabajadorDto.getTelefono());
        // atributos de trabajador
        existente.setTiposCargo(buscarCargo(trabajadorDto.getTipoCargoId()));
        existente.setSueldo(trabajadorDto.getSueldo());

        Trabajador actualizado = trabajadorRepository.save(existente);
        return trabajadorMapper.toDto(actualizado);
    }

    // eliminar un trabajador
    @Override
    public void eliminar(Long id) {
        if (!trabajadorRepository.existsById(id)) {
            throw new RuntimeException("Trabajador no encontrado con id: " + id);
        }
        trabajadorRepository.deleteById(id);
    }

    // busca en tipos_cargo la fila con ese id
    private TiposCargo buscarCargo(Byte id) {
        return tiposCargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no existe en tipos_cargo: " + id));
    }
}