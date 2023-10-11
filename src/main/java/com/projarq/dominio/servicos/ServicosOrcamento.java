package com.projarq.dominio.servicos;

import org.springframework.stereotype.Service;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.entidades.Orcamento;
import com.projarq.persistencia.OrcamentoRepository;

@Service
public class ServicosOrcamento {
    private final OrcamentoRepository orcamentoRepository;
    private final ServicosCustoAdicional servicosCustoAdicional;
    private final ServicoCustoBasico servicoCustoBasico;
    private final ServicosCidade servicosCidade;
    public ServicosOrcamento(OrcamentoRepository orcamentoRepository, ServicosCidade servicosCidade,ServicosCustoAdicional servicosCustoAdicional, ServicoCustoBasico servicoCustoBasico) {
        this.orcamentoRepository = orcamentoRepository;
        this.servicosCustoAdicional = servicosCustoAdicional;
        this.servicoCustoBasico = servicoCustoBasico;
        this.servicosCidade = servicosCidade;
    }

    public Cidade obterCidadePorId(Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    public double calcularPrecoDeNovaEncomenda(Cidade cidadeOrigem, Cidade cidadeDestino, int gramas ) {
        double custoBasico = servicoCustoBasico.getCustoBasico(cidadeOrigem, cidadeDestino, gramas);
        double precoAdicional = servicosCustoAdicional.getAdicionalPorPeso(gramas); 
        double precoTotal = custoBasico + precoAdicional;
        return precoTotal;
    }
}
