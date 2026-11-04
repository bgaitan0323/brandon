package com.brandon.brandon.controllers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.services.TrabajadorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final TrabajadorServices trabajadorServices;

    // Registrar nuevo trabajador
    @PostMapping
    public ResponseEntity<TrabajadorDto> guardar(@Valid @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto guardado = trabajadorServices.guardar(trabajadorDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    //  Listar trabajadores
    @GetMapping
    public ResponseEntity<List<TrabajadorDto>> listarTrabajadores() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }

   // consultar trabajador por id 
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDto> consultarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(trabajadorServices.consultarPorId(id));
    }

    //  Actualizar un trabajador 
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDto> actualizar(@PathVariable Long id,
                                                    @RequestBody TrabajadorDto trabajadorDto) {
        return ResponseEntity.ok(trabajadorServices.actualizar(id, trabajadorDto));
    }
}