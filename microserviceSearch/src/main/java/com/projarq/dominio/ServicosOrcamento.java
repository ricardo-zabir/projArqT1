package com.projarq.dominio;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

import com.projarq.dominio.Orcamento;
import com.projarq.dominio.RepOracamento;

@Service
public class ServicosOrcamento {
    private final RepOracamento orcamentoRepository;

    public ServicosOrcamento(RepOracamento orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

   
    public List<Orcamento> listarOrcamentosPorData(LocalDate data) {
        return orcamentoRepository
            .findAll()
            .stream()
            .filter(orcamento -> orcamento.getDataOrcamento().isEqual(data))
            .collect(Collectors.toList());
    }
    
}
