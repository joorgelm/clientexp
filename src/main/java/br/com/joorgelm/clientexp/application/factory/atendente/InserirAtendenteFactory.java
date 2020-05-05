package br.com.joorgelm.clientexp.application.factory.atendente;

import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirAtendenteFactory {

    @Bean
    public InserirAtendenteUsecase createInserirAtendenteUseCase(AtendenteDataProvider atendenteDataProvider) {
        return InserirAtendenteUsecase
                .builder()
                .atendenteDataProvider(atendenteDataProvider)
                .build();
    }
}
