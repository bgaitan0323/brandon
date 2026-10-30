package com.brandon.brandon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class UsuarioDto {

    private Long id;

    @JsonProperty("nomb")
    @NotBlank(message = "el nombre es obligatorio")
    @Size(min = 2, max = 60,
          message = "el nombre debe tener entre 2 y 60 caracteres")
    private String nombres;

    @JsonProperty("apell")
    @NotBlank(message = "el apellido es obligatorio")
    @Size(min = 2, max = 60,
          message = "el apellido debe tener entre 2 y 60 caracteres")
    private String apellidos;

    @JsonProperty("direc")
    @Size(min = 5, max = 120,
          message = "la direccion debe tener entre 5 y 120 caracteres")
    private String direccion;

    @JsonProperty("tele")
    @Pattern(regexp = "^[0-9+\\-]+$",
             message = "el telefono contiene caracteres no permitidos")
    @Size(max = 20, message = "el telefono no puede superar 20 caracteres")
    private String telefono;
}