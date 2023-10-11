package com.projarq.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projarq.dominio.entidades.Encomenda;
import com.projarq.dominio.repositorios.RepCidade;  

@Component
public class OrcamentoRepository {
    private List<Encomenda> encomendas = new ArrayList<>();
    

    public OrcamentoRepository() {
        
        

    }
    public Encomenda salvar(Encomenda encomenda) {
        encomendas.add(encomenda);
        return encomenda;
    }

    // public Cidade findById(Long id) {
    //     for (Cidade cidade : cidades) {
    //         if (cidade.getId().equals(id)) {
    //             return cidade;
    //         }
    //     }
    //     return null;
    // }

    // public List<Encomenda> findAll() {
    //     return encomendas;
    // }

    // public void delete(Long id) {
    //     cidades.removeIf(cidade -> cidade.getId().equals(id));
    // }
}
