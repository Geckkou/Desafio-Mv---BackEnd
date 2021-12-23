package com.mv.desafioMv.services;

import com.mv.desafioMv.exception.BussinessException;
import com.mv.desafioMv.model.Cliente;
import com.mv.desafioMv.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new BussinessException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean cnpjEmUso = clienteRepository.findByCnpjIgnoreCaseContaining(cliente.getCnpj())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(cnpjEmUso) {
            throw new BussinessException("Cliente já cadastrado");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente excluir(Long clienteId) {
        Cliente cliente = this.buscar(clienteId);

        clienteRepository.deleteById(cliente.getId());
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Long clienteId, Cliente cliente) {
        Cliente cli = this.buscar(clienteId);

        cliente.setId(cli.getId());
        cliente = clienteRepository.save(cliente);

        return cliente;
    }
}
