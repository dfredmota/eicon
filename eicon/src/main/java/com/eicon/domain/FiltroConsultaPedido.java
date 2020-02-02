package com.eicon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FiltroConsultaPedido {

    private Long numeroPedido;
    private Long clienteId;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataCadastro;
}
