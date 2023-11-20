package com.projarq.aplicacao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projarq.dominio.Orcamento;
import com.projarq.dominio.RepOracamento;
import com.projarq.dominio.ServicosOrcamento;
import com.projarq.persistencia.OrcamentoRepositoryJPA;

@Service
public class SalvaOrcamento_UC{
    private final RepOracamento orcamentoRep;

    public SalvaOrcamento_UC(RepOracamento repOracamento) {
        this.orcamentoRep = repOracamento;
    }

    public Orcamento run(Orcamento orcamento) {
        return orcamentoRep.salvar(orcamento);
    }
}
