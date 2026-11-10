package com.brandon.brandon.dtos;

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
public class TrabajadorDto extends UsuarioDto {

    // atributos de trabajador
    @NotNull(message = "el cargo es obligatorio")
    private Byte tipoCargoId;

    @PositiveOrZero(message = "el sueldo no puede ser negativo")
    private Double sueldo;
}