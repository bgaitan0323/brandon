package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.dtos.TrabajadorDtoResponse;
import com.brandon.brandon.models.Trabajador;
import org.springframework.stereotype.Component;

@Component
public class TrabajadorMapperImpl implements TrabajadorMapper {

    @Override
    public TrabajadorDtoResponse toDto(Trabajador trabajador) {
        if (trabajador == null) {
            return null;
        }
        return TrabajadorDtoResponse.builder()
                // atributos de usuario
                .id(trabajador.getId())
                .nombres(trabajador.getNom())
                .apellidos(trabajador.getApe())
                .direccion(trabajador.getDir())
                .telefono(trabajador.getTel())
                // atributos de trabajador
                .tipoCargoId(trabajador.getTiposCargo() != null
                        ? trabajador.getTiposCargo().getId() : null)
                .cargo(trabajador.getTiposCargo() != null
                        ? trabajador.getTiposCargo().getNombre() : null)
                .sueldo(trabajador.getSueldo())
                .build();
    }

    @Override
    public Trabajador toEntity(TrabajadorDto trabajadorDto) {
        if (trabajadorDto == null) {
            return null;
        }
        return Trabajador.builder()
                // atributos de usuario
                .id(trabajadorDto.getId())
                .nom(trabajadorDto.getNombres())
                .ape(trabajadorDto.getApellidos())
                .dir(trabajadorDto.getDireccion())
                .tel(trabajadorDto.getTelefono())
                // atributos de trabajador (el cargo lo asigna el service)
                .sueldo (trabajadorDto.getSueldo())
                .build();
    }
}