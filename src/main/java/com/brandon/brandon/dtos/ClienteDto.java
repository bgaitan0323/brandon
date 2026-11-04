package com.brandon.brandon.dtos;

import jakarta.validation.constraints.NotBlank;        
import jakarta.validation.constraints.PositiveOrZero;  
import jakarta.validation.constraints.Size;            
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
    @NotBlank(message = "el tipo de cliente es obligatorio")                          
    @Size(max = 50, message = "el tipo de cliente no puede superar 50 caracteres")    
    private String tipCli;

    @PositiveOrZero(message = "los puntos no pueden ser negativos")                   
    private Integer puntos;
}