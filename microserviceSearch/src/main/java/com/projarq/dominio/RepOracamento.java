package com.projarq.dominio;

import java.util.List;

import com.projarq.dominio.Orcamento;

public interface RepOracamento {
    Orcamento salvar(Orcamento orcamento);

    Orcamento findById(Long id);

    List<Orcamento> findAll();

    void delete(Long id);
}
