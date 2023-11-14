package com.projarq.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projarq.dominio.entidades.Orcamento;  

@Component
public class OrcamentoRepository {
    private List<Orcamento> orcamentos = new ArrayList<>();
    

    public OrcamentoRepository() {
        
        

    }
    public Orcamento salvar(Orcamento orcamento) {
        orcamentos.add(orcamento);
        return orcamento;
    }

    // public Cidade findById(Long id) {
    //     for (Cidade cidade : cidades) {
    //         if (cidade.getId().equals(id)) {
    //             return cidade;
    //         }
    //     }
    //     return null;
    // }

    // public List<Orcamento> findAll() {
    //     return Orcamentos;
    // }

    // public void delete(Long id) {
    //     cidades.removeIf(cidade -> cidade.getId().equals(id));
    // }
}
