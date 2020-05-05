package br.com.joorgelm.clientexp.adapter.entrypoint.controller.atendente;

import br.com.joorgelm.clientexp.domain.usecase.atendente.buscar.BuscarAtendenteOutput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.buscar.BuscarAtendenteUsecase;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteInput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteOutput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteUsecase;
import br.com.joorgelm.clientexp.domain.usecase.atendente.excluir.ExcluirAtendenteUsecase;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteInput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteOutput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteUsecase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AtendenteControllerImp implements AtendenteController {
    private InserirAtendenteUsecase inserirAtendenteUsecase;
    private BuscarAtendenteUsecase buscarAtendenteUsecase;
    private ExcluirAtendenteUsecase excluirAtendenteUsecase;
    private EditarAtendenteUsecase editarAtendenteUsecase;

    @Override
    public ResponseEntity<InserirAtendenteOutput> inserir(InserirAtendenteInput atendente) {
        InserirAtendenteOutput output = inserirAtendenteUsecase.inserir(atendente);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BuscarAtendenteOutput> buscar(String id) {
        BuscarAtendenteOutput output = buscarAtendenteUsecase.buscarPorId(id);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BuscarAtendenteOutput> excluir(String idAtendente) {
        excluirAtendenteUsecase.excluir(idAtendente);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<EditarAtendenteOutput> editar(String idAtendente, EditarAtendenteInput atendente) {
        EditarAtendenteOutput output = editarAtendenteUsecase.editar(idAtendente, atendente);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
