package com.brandon.brandon.services;

import com.brandon.brandon.dtos.TrabajadorDto;
import java.util.List;

public interface TrabajadorServices {

    // registrar un nuevo trabajador
    TrabajadorDto guardar(TrabajadorDto trabajadorDto);

    // listar todos los trabajadores
    List<TrabajadorDto> listarTodos();

    // consultar trabajador por id
    TrabajadorDto consultarPorId(Long id);

    // actualizar un trabajador
    TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto);
}
