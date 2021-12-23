package com.mv.desafioMv.controller;

import com.mv.desafioMv.model.Cliente;
import com.mv.desafioMv.services.ClienteService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/clientes")
@Api(value = "API REST Clientes")
@CrossOrigin(origins = "*")

public class ClienteController {

    ClienteService clienteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping(value = "/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> findById(@PathVariable Long clienteId) {
        return ResponseEntity.ok(clienteService.buscar(clienteId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @PutMapping(value = "{clienteId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@PathVariable Long clienteId,
                                           @Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.atualizar(clienteId, cliente));
    }

    @DeleteMapping(value = "{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> delete(@PathVariable Long clienteId) {
        return ResponseEntity.ok(clienteService.excluir(clienteId));
    }
}
