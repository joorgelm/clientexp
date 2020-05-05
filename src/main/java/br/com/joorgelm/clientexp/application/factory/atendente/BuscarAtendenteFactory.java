package br.com.joorgelm.clientexp.application.factory.atendente;

import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import br.com.joorgelm.clientexp.domain.usecase.atendente.buscar.BuscarAtendenteUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAtendenteFactory {

    @Bean
    public BuscarAtendenteUsecase createBuscarAtendenteUsecase(AtendenteDataProvider atendenteDataProvider){
        return BuscarAtendenteUsecase
                .builder()
                .atendenteDataProvider(atendenteDataProvider)
                .build();
    }
}
