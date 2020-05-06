package br.com.joorgelm.clientexp.adapter.entrypoint;

import br.com.joorgelm.clientexp.domain.interfaces.AtendenteDataProvider;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteInput;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class AtendenteIntegrationTest {

    @Autowired
    private AtendenteDataProvider atendenteDataProvider;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveInserirAtendente() throws Exception {

        String nome = "jorge";
        String email = "jorge@gmail.com";
        String password = "123";
        InserirAtendenteInput input = InserirAtendenteInput
                .builder()
                .nome(nome)
                .email(email)
                .password(password)
                .build();

        String requestJson = new Gson().toJson(input);

        ResultActions resposta = mockMvc.perform(post("/atendentes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));

        resposta
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("id")))
                .andExpect(jsonPath("nome", equalTo(nome)))
                .andExpect(jsonPath("email", equalTo(email)));


    }
}
