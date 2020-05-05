package br.com.joorgelm.clientexp.adapter.entrypoint.controller.atendente;

import br.com.joorgelm.clientexp.domain.usecase.atendente.buscar.BuscarAtendenteOutput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteInput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.editar.EditarAtendenteOutput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteInput;
import br.com.joorgelm.clientexp.domain.usecase.atendente.inserir.InserirAtendenteOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "atendentes")
public interface AtendenteController {

    @PostMapping("/")
    @ResponseBody
    ResponseEntity<InserirAtendenteOutput> inserir(
            @RequestBody InserirAtendenteInput atendente
    );

    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<BuscarAtendenteOutput> buscar(
            @PathVariable("id") String idAtendente
    );

    @DeleteMapping("/{id}")
    @ResponseBody
    ResponseEntity<BuscarAtendenteOutput> excluir(
            @PathVariable("id") String idAtendente
    );

    @PutMapping("/{id}")
    @ResponseBody
    ResponseEntity<EditarAtendenteOutput> editar(
            @PathVariable("id") String idAtendente,
            @RequestBody EditarAtendenteInput atendente
    );
}
