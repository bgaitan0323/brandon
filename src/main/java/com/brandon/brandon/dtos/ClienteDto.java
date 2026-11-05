package com.brandon.brandon.dtos;

import com.brandon.brandon.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClienteDto extends UsuarioDto {

    // atributos de cliente
    @NotNull(message = "el tipo de cliente es obligatorio")
    private TipoCliente tipCli;

    @JsonProperty("pts")
    @PositiveOrZero(message = "los puntos no pueden ser negativos")
    private Integer puntos;
}