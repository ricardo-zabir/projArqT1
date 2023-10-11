package com.projarq.aplicacao;

import org.springframework.stereotype.Component;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.servicos.ServicosOrcamento;
@Component
public class CalculaOrcamento_UC {
    private final ServicosOrcamento servicosOrcamento;
    public CalculaOrcamento_UC(ServicosOrcamento servicosOrcamento){
        this.servicosOrcamento = servicosOrcamento;
    }

    public double run(Long origem, Long destino, int gramas){
        Cidade cidadeOrigem = servicosOrcamento.obterCidadePorId(origem);
        Cidade cidadeDestino = servicosOrcamento.obterCidadePorId(destino);
        return servicosOrcamento.calcularPrecoDeNovaEncomenda(cidadeOrigem, cidadeDestino, gramas);
    }
}
