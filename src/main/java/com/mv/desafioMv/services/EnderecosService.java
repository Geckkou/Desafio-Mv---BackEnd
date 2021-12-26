package com.mv.desafioMv.services;

import com.mv.desafioMv.exception.BussinessException;
import com.mv.desafioMv.model.Cliente;
import com.mv.desafioMv.model.Enderecos;
import com.mv.desafioMv.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class EnderecosService {

    EnderecoRepository enderecoRepository;
    ClienteService clienteService;

    public List<Enderecos> listar() {
        return enderecoRepository.findAll();
    }

    public Enderecos buscar(Long enderecoId) {
        return enderecoRepository.findById(enderecoId)
                .orElseThrow(() -> new BussinessException("Endereço não existe !"));
    }

    @Transactional
    public Enderecos salvar(Enderecos enderecos) {
        return enderecoRepository.save(enderecos);
    }

    @Transactional
    public Enderecos excluir(Long enderecoId) {
        Enderecos enderecos = this.buscar(enderecoId);

        enderecoRepository.deleteById(enderecos.getId());
        return enderecos;
    }

    @Transactional
    public Enderecos atualizar(Long enderecoId, Enderecos enderecos) {
        Enderecos enderecoEdit = this.buscar(enderecoId);

        Enderecos enderecoNovo = enderecos;


        enderecoNovo.setBairro(enderecoEdit.getBairro());
        enderecoNovo.setCidade(enderecoEdit.getCidade());
        enderecoNovo.setComplemento(enderecoEdit.getComplemento());
        enderecoNovo.setEstado(enderecoEdit.getEstado());
        enderecoNovo.setRua(enderecoEdit.getRua());
        enderecoNovo.setId(enderecoEdit.getId());

        return enderecoRepository.save(enderecoNovo);

    }
}
