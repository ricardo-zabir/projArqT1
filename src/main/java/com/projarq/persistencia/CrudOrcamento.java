package com.projarq.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projarq.dominio.entidades.Orcamento;

@Repository
public interface CrudOrcamento extends CrudRepository<Orcamento, Long> {

}
