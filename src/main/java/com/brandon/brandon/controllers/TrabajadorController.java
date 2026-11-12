package com.brandon.brandon.controllers;

import com.brandon.brandon.dtos.TrabajadorDto;
import com.brandon.brandon.dtos.TrabajadorDtoResponse;
import com.brandon.brandon.services.TrabajadorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @PostMapping("/crear")
    public ResponseEntity<TrabajadorDtoResponse> guardar(@Valid @RequestBody TrabajadorDto trabajadorDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trabajadorServices.guardar(trabajadorDto));
    }

    // Listar trabajadores
    @GetMapping
    public ResponseEntity<List<TrabajadorDtoResponse>> listarTrabajadores() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }

    // Consultar por id en la url
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorServices.consultarPorId(id));
    }

    // Consultar por id oculto 
    @PostMapping("/buscar")
    public ResponseEntity<TrabajadorDtoResponse> consultarPorIdOculto(@RequestBody TrabajadorDto dto) {
        return ResponseEntity.ok(trabajadorServices.consultarPorId(dto.getId()));
    }

    // Actualizar un trabajador
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> update(@PathVariable Long id,
    @Valid @RequestBody TrabajadorDto trabajadorDto) {
        return ResponseEntity.ok(trabajadorServices.actualizar(id, trabajadorDto));
    }

    // Eliminar un trabajador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        trabajadorServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}