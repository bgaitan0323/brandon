package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.models.Trabajador;
import org.springframework.stereotype.Component;

@Component
public class TrabajadorMapperImpl implements TrabajadorMapper {

    @Override
    public TrabajadorDto toDto(Trabajador trabajador) {
        if (trabajador == null) {
            return null;
        }
        return TrabajadorDto.builder()
                // atributos de usuario
                .id(trabajador.getId())
                .nombres(trabajador.getNom())
                .apellidos(trabajador.getApe())
                .direccion(trabajador.getDir())
                .telefono(trabajador.getTel())
                // atributos de trabajador
                .cargo(trabajador.getCargo())
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
                // atributos de trabajador
                .cargo(trabajadorDto.getCargo())
                .sueldo(trabajadorDto.getSueldo())
                .build();
    }
}