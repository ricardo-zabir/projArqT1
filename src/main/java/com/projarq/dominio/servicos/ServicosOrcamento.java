package com.projarq.dominio.servicos;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.entidades.Orcamento;
import com.projarq.dominio.repositorios.RepOracamento;

@Service
public class ServicosOrcamento {
    private final RepOracamento orcamentoRepository;
    private final InterfaceServicosCustoAdicional servicosCustoAdicional;
    private final ServicoCustoBasico servicoCustoBasico;
    private final ServicosCidade servicosCidade;
    private final ServicoImposto servicoImposto;

    public ServicosOrcamento(RepOracamento orcamentoRepository,
            ServicosCidade servicosCidade,
            InterfaceServicosCustoAdicional servicosCustoAdicional,
            ServicoCustoBasico servicoCustoBasico,
            ServicoImposto servicoImposto) {
        this.orcamentoRepository = orcamentoRepository;
        this.servicosCidade = servicosCidade;
        this.servicosCustoAdicional = servicosCustoAdicional;
        this.servicoCustoBasico = servicoCustoBasico;
        this.servicoImposto = servicoImposto;
    }

    public Cidade obterCidadePorId(Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    public double calcularPrecoDeNovaEncomenda(Cidade cidadeOrigem, Cidade cidadeDestino, int gramas) {
        Long id = 1L;
        double custoBasico = servicoCustoBasico.getCustoBasico(cidadeOrigem, cidadeDestino, gramas);
        double precoAdicional = servicosCustoAdicional.getAdicionalPorPeso(gramas);
        double imposto = servicoImposto.getImposto(custoBasico);
        double precoTotal = custoBasico + precoAdicional + imposto;
        LocalDate data = LocalDate.now();
        Orcamento orcamento = new Orcamento(id, cidadeOrigem, cidadeDestino, gramas, precoTotal, imposto, 0.00, data);
        orcamentoRepository.salvar(orcamento);
        return precoTotal;
    }

    public List<Orcamento> listarOrcamentosPorData(LocalDate data) {
        return orcamentoRepository
            .findAll()
            .stream()
            .filter(orcamento -> orcamento.getDataOrcamento().isEqual(data))
            .collect(Collectors.toList());
    }
    
}
