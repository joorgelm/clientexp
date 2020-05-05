package br.com.joorgelm.clientexp.domain.usecase.atendente.inserir;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InserirAtendenteOutput {

    private String id;
    private String nome;
    private String email;
}
