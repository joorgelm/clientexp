package br.com.joorgelm.clientexp.domain.usecase.atendente.inserir;

import br.com.joorgelm.clientexp.application.factory.atendente.InserirAtendenteFactory;
import br.com.joorgelm.clientexp.domain.exception.ParametroInvalidoException;
import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class InserirAtendenteUsecaseTest {

    @InjectMocks
    private InserirAtendenteFactory inserirAtendenteFactory;

    private InserirAtendenteUsecase inserirAtendenteUsecase;
    private AtendenteDataProvider mockAtendenteDataProvider;

    @Before
    public void prepareTest() {
        this.mockAtendenteDataProvider = mock(AtendenteDataProvider.class);
        inserirAtendenteUsecase = this.inserirAtendenteFactory.createInserirAtendenteUseCase(mockAtendenteDataProvider);
    }

    @Test(expected = ParametroInvalidoException.class)
    public void deveFalharSeParametroNomeForNulo() {
        InserirAtendenteInput entrada = InserirAtendenteInput.builder()
                .nome("")
                .email("teste")
                .password("teste")
                .build();

        inserirAtendenteUsecase.inserir(entrada);
    }

    @Test(expected = ParametroInvalidoException.class)
    public void deveFalharSeParametroEmailForNulo() {
        InserirAtendenteInput entrada = InserirAtendenteInput.builder()
                .nome("Jesus")
                .email("")
                .password("teste")
                .build();

        inserirAtendenteUsecase.inserir(entrada);
    }

    @Test(expected = ParametroInvalidoException.class)
    public void deveFalharSeParametroPasswordForNulo() {
        InserirAtendenteInput entrada = InserirAtendenteInput.builder()
                .nome("Jesus")
                .email("jesus@gmail.com")
                .password("")
                .build();

        inserirAtendenteUsecase.inserir(entrada);
    }
}
