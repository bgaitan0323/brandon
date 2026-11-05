package com.brandon.brandon.controllers;

import com.brandon.brandon.dtos.UsuarioDto;
import com.brandon.brandon.services.UsuarioServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    //  Registrar nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> guardar(@Valid @RequestBody UsuarioDto usuarioDto) {

        UsuarioDto usuarioGuardado = usuarioServices.guardar(usuarioDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioGuardado);
    }


    //Listar Usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        return ResponseEntity.ok(usuarioServices.listarTodos());
    }

    // Consultar usuario por id
    @GetMapping("/{id}")
    
public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id) {
        UsuarioDto usuarioDto = usuarioServices.buscarPorId(id);
        return ResponseEntity.ok(usuarioServices.buscarPorId(id));
    }


  // consulta por post
@PostMapping("/buscar")
public ResponseEntity<UsuarioDto> buscarPorIdPost(@RequestBody Map<String, Long> body) {
    Long id = body.get("id");
    UsuarioDto encontrado = usuarioServices.buscarPorId(id);
    return ResponseEntity.ok(encontrado);
}
    // eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    // Actualizar un usuario 
@PutMapping("/{id}")
public ResponseEntity<UsuarioDto> actualizar(@PathVariable Long id,
 @Valid @RequestBody UsuarioDto usuarioDto) {
    return ResponseEntity.ok(usuarioServices.actualizar(id, usuarioDto));
}
}