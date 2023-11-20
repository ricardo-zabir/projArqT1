package com.projarq.dominio.servicos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private final ServicosPromocoes servicosPromocoes;

    public ServicosOrcamento(RepOracamento orcamentoRepository,
            ServicosCidade servicosCidade,
            InterfaceServicosCustoAdicional servicosCustoAdicional,
            ServicoCustoBasico servicoCustoBasico,
            ServicoImposto servicoImposto,
            ServicosPromocoes servicosPromocoes) {
        this.orcamentoRepository = orcamentoRepository;
        this.servicosCidade = servicosCidade;
        this.servicosCustoAdicional = servicosCustoAdicional;
        this.servicoCustoBasico = servicoCustoBasico;
        this.servicoImposto = servicoImposto;
        this.servicosPromocoes = servicosPromocoes;
    }

    public Cidade obterCidadePorId(Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    public Orcamento calcularPrecoDeNovaEncomenda(String cepOrigem, String cepDestino, int gramas) throws IOException {
        Long id = 1L;
        Cidade cidadeOrigem = servicosCidade.obterCidadePorCep(cepOrigem);
        Cidade cidadeDestino = servicosCidade.obterCidadePorCep(cepDestino);
        if (cidadeOrigem == null || cidadeDestino == null) {
            throw new IllegalArgumentException("Cidade não encontrada");
        }
        double custoBasico = servicoCustoBasico.getCustoBasico(cidadeOrigem, cidadeDestino, gramas);
        double precoAdicional = servicosCustoAdicional.getAdicionalPorPeso(gramas);
        double imposto = servicoImposto.getImposto(custoBasico, cidadeOrigem);
        double precoTotal = custoBasico + precoAdicional + imposto;
        double desconto = servicosPromocoes.calculaDesconto(cidadeOrigem, cidadeDestino, gramas, precoTotal);
        precoTotal -= desconto;
        LocalDate data = LocalDate.now();
        Orcamento orcamento = new Orcamento(id, cepOrigem, cepDestino, gramas, precoTotal, imposto, desconto, data);
        ResponseEntity<Orcamento> orc = new RestTemplate().postForEntity("http://localhost:8080/servicoorcamento/salvaorcamento", orcamento, Orcamento.class);
       // orcamentoRepository.salvar(orcamento);
        return orc.getBody();
    }

    public List<Orcamento> listarOrcamentosPorData(LocalDate data) {
        return orcamentoRepository
            .findAll()
            .stream()
            .filter(orcamento -> orcamento.getDataOrcamento().isEqual(data))
            .collect(Collectors.toList());
    }
    
}
