package br.com.joorgelm.clientexp.application.factory.atendente;

import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import br.com.joorgelm.clientexp.domain.usecase.atendente.excluir.ExcluirAtendenteUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExcluirAtendenteFactory {

    @Bean
    public ExcluirAtendenteUsecase createExcluirAtendenteUsecase(AtendenteDataProvider atendenteDataProvider) {
        return ExcluirAtendenteUsecase
                .builder()
                .atendenteDataProvider(atendenteDataProvider)
                .build();
    }
}
