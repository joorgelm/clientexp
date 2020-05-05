package br.com.joorgelm.clientexp.application.factory.atendente;

import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarAtendenteFactory {

    @Bean
    public EditarAtendenteUsecase createEditarAtendenteUsecase(AtendenteDataProvider atendenteDataProvider) {
        return EditarAtendenteUsecase
                .builder()
                .atendenteDataProvider(atendenteDataProvider)
                .build();
    }
}
