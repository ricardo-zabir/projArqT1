package com.projarq.aplicacao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import com.projarq.dominio.entidades.Orcamento;
import com.projarq.dominio.servicos.ServicosOrcamento;

@Component
public class ListaOrcamentosPorData_UC {
    private final ServicosOrcamento servicosOrcamento;

    public ListaOrcamentosPorData_UC(ServicosOrcamento servicosOrcamento) {
        this.servicosOrcamento = servicosOrcamento;
    }

    public List<Orcamento> run(LocalDate data) {
        return servicosOrcamento.listarOrcamentosPorData(data);
    }
}
