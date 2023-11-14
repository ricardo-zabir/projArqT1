package com.projarq.persistencia;

import com.projarq.dominio.repositorios.RepOracamento;
import com.projarq.dominio.entidades.Orcamento;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Primary
@Repository
public class OrcamentoRepositoryJPA implements RepOracamento {
    private final CrudRepository<Orcamento, Long> repository;

    public OrcamentoRepositoryJPA(CrudRepository<Orcamento, Long> repository) {
        this.repository = repository;
    }

    @Override
    public Orcamento salvar(Orcamento orcamento) {
        return repository.save(orcamento);
    }

    @Override
    public Orcamento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Orcamento> findAll() {
        return (List<Orcamento>) repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
