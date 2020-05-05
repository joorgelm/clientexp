package br.com.joorgelm.clientexp.domain.usecase.atendente.excluir;

import br.com.joorgelm.clientexp.domain.entity.Atendente;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import lombok.Builder;

import java.util.Optional;

@Builder
public class ExcluirAtendenteUsecase {

    private AtendenteDataProvider atendenteDataProvider;

    public void excluir(String id) {

        Optional<Atendente> atendente = atendenteDataProvider.findById(id);

        if (atendente.isPresent())
            atendenteDataProvider.deleteById(id);
    }
}
