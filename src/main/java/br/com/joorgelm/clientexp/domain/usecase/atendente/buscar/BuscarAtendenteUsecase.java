package br.com.joorgelm.clientexp.domain.usecase.atendente.buscar;

import br.com.joorgelm.clientexp.domain.entity.Atendente;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import lombok.Builder;

import java.util.Optional;

@Builder
public class BuscarAtendenteUsecase {

    private AtendenteDataProvider atendenteDataProvider;

    public BuscarAtendenteOutput buscarPorId(String id) {

        Atendente atendente = buscarAtendente(id);

        return BuscarAtendenteOutput.builder()
                .id(atendente.getId())
                .nome(atendente.getNome())
                .email(atendente.getEmail())
                .build();
    }

    private Atendente buscarAtendente(String id) {
        Optional<Atendente> atendente = atendenteDataProvider.findById(id);

        // todo: melhorar
        if (atendente.isPresent())
            return atendente.get();

        return null;
    }
}
