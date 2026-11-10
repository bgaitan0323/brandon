package com.brandon.brandon.mappers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.dtos.TrabajadorDtoResponse;
import com.brandon.brandon.models.Trabajador;

public interface TrabajadorMapper {

    TrabajadorDtoResponse toDto(Trabajador trabajador);

    Trabajador toEntity(TrabajadorDto trabajadorDto);
}