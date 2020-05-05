package br.com.joorgelm.clientexp.domain.usecase.atendente.inserir;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InserirAtendenteInput {

    private String nome;
    private String email;
    private String password;
}
