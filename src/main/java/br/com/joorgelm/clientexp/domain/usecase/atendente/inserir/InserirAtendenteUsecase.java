package br.com.joorgelm.clientexp.domain.usecase.atendente.inserir;

import br.com.joorgelm.clientexp.domain.entity.Atendente;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import lombok.Builder;

import java.util.UUID;

@Builder
public class InserirAtendenteUsecase {

    private AtendenteDataProvider atendenteDataProvider;

    public InserirAtendenteOutput inserir(InserirAtendenteInput entrada) {

        Atendente atendenteCadastrado = criarAtendente(entrada);

        atendenteDataProvider.save(atendenteCadastrado);

        return InserirAtendenteOutput.builder()
                .id(atendenteCadastrado.getId())
                .nome(atendenteCadastrado.getNome())
                .email(atendenteCadastrado.getEmail())
                .build();
    }

    private Atendente criarAtendente(InserirAtendenteInput entrada) {
        return Atendente.builder()
                .id(UUID.randomUUID().toString())
                .nome(entrada.getNome())
                .email(entrada.getEmail())
                .password(entrada.getPassword())
                .build();
    }
}
