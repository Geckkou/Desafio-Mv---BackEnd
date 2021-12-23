package com.mv.desafioMv.controller;

import com.mv.desafioMv.model.Enderecos;
import com.mv.desafioMv.services.EnderecosService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/enderecos")
@Api(value = "API REST Endereços")
@CrossOrigin(origins = "*")

public class EnderecosController {

    EnderecosService enderecosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Enderecos>> findAll() {
        return ResponseEntity.ok(enderecosService.listar());
    }

    @GetMapping(value = "/{enderecosId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enderecos> findById(@PathVariable Long enderecosId) {
        return ResponseEntity.ok(enderecosService.buscar(enderecosId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enderecos> save(@Valid @RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(enderecosService.salvar(enderecos));
    }

    @PutMapping(value = "{enderecosId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enderecos> update(@PathVariable Long enderecosId,
                                            @Valid @RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(enderecosService.atualizar(enderecosId, enderecos));
    }

    @DeleteMapping(value = "{enderecosId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enderecos> delete(@PathVariable Long enderecosId) {
        return ResponseEntity.ok(enderecosService.excluir(enderecosId));
    }
}
