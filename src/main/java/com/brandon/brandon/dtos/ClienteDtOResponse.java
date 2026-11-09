package com.brandon.brandon.dtos;

import com.brandon.brandon.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ClienteDtOResponse extends UsuarioDto {

    private TipoCliente tipCli;

    @JsonProperty("pts")
    private Integer pts;
}