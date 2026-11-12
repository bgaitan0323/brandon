package com.brandon.brandon.controllers;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.dtos.ClienteDtOResponse;
import com.brandon.brandon.services.ClienteServices;
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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServices clienteServices;

    // Registrar nuevo cliente
    @PostMapping("/crear")
    public ResponseEntity<ClienteDtOResponse> guardar(@Valid @RequestBody ClienteDto clienteDto) {
        ClienteDtOResponse clienteGuardado = clienteServices.guardar(clienteDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteGuardado);
    }

    // Listar clientes
    @GetMapping
    public ResponseEntity<List<ClienteDtOResponse>> listarClientes() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    // Consultar cliente por id por url: GET /api/clientes/1
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDtOResponse> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServices.consultarPorId(id));
    }

    // Consultar cliente por id oculto (en el body): POST /api/clientes/buscar
    @PostMapping("/buscar")
    public ResponseEntity<ClienteDtOResponse> consultarPorIdOculto(@RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteServices.consultarPorId(dto.getId()));
    }

    // Actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDtOResponse> update(@PathVariable Long id,
    @Valid @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteServices.actualizar(id, clienteDto));
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}