package com.brandon.brandon.services;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.dtos.TrabajadorDtoResponse;

import java.util.List;

public interface TrabajadorServices {
    TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto);
    List<TrabajadorDtoResponse> listarTodos();
    TrabajadorDtoResponse consultarPorId(Long id);
    TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto);
    void eliminar(Long id);
}