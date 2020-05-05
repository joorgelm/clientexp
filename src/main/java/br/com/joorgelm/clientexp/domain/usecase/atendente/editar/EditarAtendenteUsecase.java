package br.com.joorgelm.clientexp.domain.usecase.atendente.editar;

import br.com.joorgelm.clientexp.domain.entity.Atendente;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import lombok.Builder;

import java.util.Optional;

@Builder
public class EditarAtendenteUsecase {

    private AtendenteDataProvider atendenteDataProvider;

    public EditarAtendenteOutput editar(String id, EditarAtendenteInput entrada) {
        Atendente atendente = buscarAtendente(id);
        editarAtendente(atendente, entrada);
        Atendente atendenteSalvo = atualizarAtendenteNoBanco(atendente);

        return criarEditarAtendenteOutput(atendenteSalvo);
    }

    private Atendente atualizarAtendenteNoBanco(Atendente atendente) {
        return atendenteDataProvider.save(atendente);
    }

    private void editarAtendente(Atendente atendente, EditarAtendenteInput entrada) {
        atendente.setNome(entrada.getNome());
        atendente.setEmail(entrada.getEmail());
        atendente.setPassword(entrada.getPassword());
    }

    private Atendente buscarAtendente(String id) {
        Optional<Atendente> atendente = atendenteDataProvider.findById(id);

        // todo: melhorar
        if (atendente.isPresent())
            return atendente.get();

        return null;
    }

    private EditarAtendenteOutput criarEditarAtendenteOutput(Atendente atendente) {
        return EditarAtendenteOutput
                .builder()
                .id(atendente.getId())
                .nome(atendente.getNome())
                .email(atendente.getEmail())
                .build();
    }
}
