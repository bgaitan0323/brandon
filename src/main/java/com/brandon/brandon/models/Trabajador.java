package com.brandon.brandon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity
@Table(name = "trabajadores")
@PrimaryKeyJoinColumn(name = "trabajador_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Trabajador extends Usuario {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cargo_id", nullable = false)
    private TiposCargo tiposCargo;

    @Column(name = "sueldo")
    private Double sueldo;

}