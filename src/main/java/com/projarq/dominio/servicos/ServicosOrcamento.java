package com.projarq.dominio.servicos;

import com.projarq.persistencia.CepApi;
import com.projarq.dominio.entidades.Cidade;
import com.projarq.persistencia.CidadeRepository;
import com.projarq.persistencia.OrcamentoRepository;

public class ServicosOrcamento {
    private final OrcamentoRepository orcamentoRepository;

    public ServicosOrcamento(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    public void calcularPrecoDeNovaEncomenda(Cidade cidadeOrigem, Cidade cidadeDestino, double gramas ) {
        double precoPelaDistancia = 0.00;
        if(cidadeOrigem.getNome().equals(cidadeDestino.getNome())) {
            precoPelaDistancia = cidadeDestino.getCustoBasicoParaSaoPaulo();
        }
        else {
            if (cidadeOrigem.getNome().equals("São Paulo") || cidadeDestino.getNome().equals("São Paulo")) {
                if(cidadeOrigem.getNome().equals("São Paulo")) {
                    precoPelaDistancia = cidadeDestino.getCustoBasicoParaSaoPaulo();
                }
                else {
                    precoPelaDistancia = cidadeOrigem.getCustoBasicoParaSaoPaulo();
                }
            }
            else {
                precoPelaDistancia = cidadeDestino.getCustoBasicoParaSaoPaulo() + cidadeOrigem.getCustoBasicoParaSaoPaulo();
            }
        }
        int emKg = (int) (Math.ceil(gramas / 1000.00));
        double adicionalPorPeso = 0.00;
        if(emKg <= 2) {
            if(emKg <= 12) {
                adicionalPorPeso = (emKg - 2) * 10.00;
            }
            else {
                adicionalPorPeso = 100 + (15.00 * (emKg - 12));
            }
        }
    }
}
