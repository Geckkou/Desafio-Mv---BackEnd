package com.mv.desafioMv.services;

import com.mv.desafioMv.exception.BussinessException;
import com.mv.desafioMv.model.Projetos;
import com.mv.desafioMv.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjetosService {

    ProjetoRepository projetoRepository;

    public List<Projetos> listar() {
        return projetoRepository.findAll();
    }

    public Projetos buscar(Long projetoId) {
        return projetoRepository.findById(projetoId)
                .orElseThrow(() -> new BussinessException("Projeto não encontrado"));
    }

    @Transactional
    public Projetos salvar(Projetos projetos) {
        boolean codigoEmUso = projetoRepository.findByCodigo(projetos.getCodigo())
                .stream()
                .anyMatch(projetoExistente -> !projetoExistente.equals(projetos));

        if(codigoEmUso) {
            throw new BussinessException("Projeto já existe");
        }

        return projetoRepository.save(projetos);
    }

    @Transactional
    public Projetos excluir(Long projetoId) {
        Projetos projetos = this.buscar(projetoId);

        projetoRepository.deleteById(projetos.getId());
        return projetos;
    }

    @Transactional
    public Projetos atualizar(Long projetoId, Projetos projetos) {
        Projetos proj = this.buscar(projetoId);

        proj.setId(proj.getId());
        projetos = projetoRepository.save(projetos);

        return projetos;
    }
}
