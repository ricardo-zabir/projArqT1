package com.projarq.persistencia;

import com.projarq.dominio.repositorios.RepCidade;
import com.projarq.dominio.entidades.Cidade;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Primary
@Repository
public class CiadadeRepositoryJPA implements RepCidade {
    private final CrudRepository<Cidade, Long> repository;

    public CiadadeRepositoryJPA(CrudRepository<Cidade, Long> repository) {
        this.repository = repository;
    }

    @Override
    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }

    @Override
    public Cidade findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cidade> findAll() {
        return (List<Cidade>) repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
