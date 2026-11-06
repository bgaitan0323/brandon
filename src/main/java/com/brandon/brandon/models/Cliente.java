package com.brandon.brandon.models;

import com.brandon.brandon.enums.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "cliente_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Cliente extends Usuario {

    // Relación con la tabla tipos_cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cliente_id")
    private TiposCliente tiposCliente;

    // Se guarda el número (0, 1, 2...)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_cliente_num")
    private TipoCliente tipoClienteNum;

    // Se guarda el texto (REGULAR, VIP...)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", length = 20)
    private TipoCliente tipoCliente;

    @Column(name = "puntos")
    private Integer puntos;

}