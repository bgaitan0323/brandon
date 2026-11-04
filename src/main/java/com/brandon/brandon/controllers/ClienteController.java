package com.brandon.brandon.controllers;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.services.ClienteServices;
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
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServices clienteServices;

    //  Registrar nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDto> guardar(@Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteGuardado = clienteServices.guardar(clienteDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteGuardado);
    }

    //  Listar clientes
    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    // consultar cliente por id 
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> consultarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(clienteServices.consultarPorId(id));
    }

    //  Actualizar un cliente (id en la url)
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> Update(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteActualizado = clienteServices.actualizar(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    //  Actualizar un cliente 
    @PostMapping("/actualizar")
    public ResponseEntity<ClienteDto> actualizar(@RequestBody ClienteDto clienteDto) {
        Long id = clienteDto.getId();
        ClienteDto clienteActualizado = clienteServices.actualizar(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

}