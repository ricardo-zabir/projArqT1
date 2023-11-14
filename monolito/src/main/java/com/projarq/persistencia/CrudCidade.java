package com.projarq.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projarq.dominio.entidades.Cidade;

@Repository
public interface CrudCidade extends CrudRepository<Cidade, Long> {
    // Métodos personalizados, se necessário.
}
