package com.mv.desafioMv.controller;

import com.mv.desafioMv.model.Projetos;
import com.mv.desafioMv.services.ProjetosService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/projetos")
@Api(value = "API REST Projetos")
@CrossOrigin(origins = "*")

public class ProjetoController {

    ProjetosService projetosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projetos>> listar() {
        return ResponseEntity.ok(projetosService.listar());
    }

    @GetMapping(value = "/{projetosId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projetos> findById(@PathVariable Long projetosId) {
        return ResponseEntity.ok(projetosService.buscar(projetosId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projetos> save(@Valid @RequestBody Projetos projetos) {
        return ResponseEntity.ok(projetosService.salvar(projetos));
    }

    @PutMapping(value = "{projetosId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projetos> update(@PathVariable Long projetosId,
                                           @Valid @RequestBody Projetos projetos) {
        return ResponseEntity.ok(projetosService.atualizar(projetosId, projetos));
    }

    @DeleteMapping(value = "{projetosId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projetos> delete(@PathVariable Long projetosId) {
        return ResponseEntity.ok(projetosService.excluir(projetosId));
    }

}
