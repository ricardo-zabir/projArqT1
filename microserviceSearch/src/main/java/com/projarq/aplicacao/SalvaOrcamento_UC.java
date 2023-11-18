package com.projarq.aplicacao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import com.projarq.dominio.Orcamento;
import com.projarq.dominio.RepOracamento;
import com.projarq.dominio.ServicosOrcamento;
import com.projarq.persistencia.OrcamentoRepositoryJPA;

@Component
public class SalvaOrcamento_UC{
    private final RepOracamento orcamentoRep;

    public SalvaOrcamento_UC(RepOracamento repOracamento) {
        this.orcamentoRep = repOracamento;
    }

    public Orcamento run(Orcamento orcamento) {
        return orcamentoRep.salvar(orcamento);
    }
}
