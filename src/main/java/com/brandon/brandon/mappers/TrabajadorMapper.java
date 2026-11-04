package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.models.Trabajador;

public interface TrabajadorMapper {

    TrabajadorDto toDto(Trabajador trabajador);

    Trabajador toEntity(TrabajadorDto trabajadorDto);
}