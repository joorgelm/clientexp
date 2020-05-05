package br.com.joorgelm.clientexp.domain.usecase.atendente.editar;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditarAtendenteOutput {

    private String id;
    private String nome;
    private String email;
}
