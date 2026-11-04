package com.brandon.brandon.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class TrabajadorDto extends UsuarioDto {

    // atributos de trabajador
    private String cargo;
    private Double sueldo;
}