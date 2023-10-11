package com.projarq.dominio.repositorios;

import java.util.List;

import com.projarq.dominio.entidades.Cidade;

public interface RepCidade {
    Cidade salvar(Cidade cidade);

    Cidade findById(Long id);

    List<Cidade> findAll();

    void delete(Long id);
}
