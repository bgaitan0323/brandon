package com.brandon.brandon.dtos;

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
    private String tipCli;
    private Integer puntos;
}