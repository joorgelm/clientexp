package br.com.joorgelm.clientexp.domain.usecase.atendente.inserir;

import br.com.joorgelm.clientexp.domain.entity.Atendente;
import br.com.joorgelm.clientexp.domain.exception.ParametroInvalidoException;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import lombok.Builder;

import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Builder
public class InserirAtendenteUsecase {

    /***
     * Todo caso de uso geralmente tera apenas um metodo publico
     ***/

    private AtendenteDataProvider atendenteDataProvider;

    public InserirAtendenteOutput inserir(InserirAtendenteInput entrada) {

        validaEntrada(entrada);

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

    private void validaEntrada(InserirAtendenteInput entrada) {
        validarParametroNome(entrada.getNome());
        validarParametroEmail(entrada.getEmail());
        validarParametroPassword(entrada.getPassword());
    }

    private void validarParametroNome(String nome) {
        if (isEmpty(nome))
            throw new ParametroInvalidoException("nome");
    }

    private void validarParametroEmail(String email) {
        if (isEmpty(email))
            throw new ParametroInvalidoException("email");
    }

    private void validarParametroPassword(String password) {
        if (isEmpty(password))
            throw new ParametroInvalidoException("password");
    }
}
