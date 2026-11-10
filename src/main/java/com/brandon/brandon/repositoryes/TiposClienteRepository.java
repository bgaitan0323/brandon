package com.brandon.brandon.repositoryes;

import com.brandon.brandon.models.TiposCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TiposClienteRepository extends JpaRepository<TiposCliente, Byte> {

    Optional<TiposCliente> findByNombre(String nombre);
}