package com.projarq.servicos;

import com.projarq.domain.Cidade;
import com.projarq.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServicosCidade {
    private final CidadeRepository cidadeRepository;

    public ServicosCidade(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Iterable<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade criarCidade(Long id, String nome, double custoBasicoParaSaoPaulo) {
        Cidade cidade = new Cidade(id,nome, custoBasicoParaSaoPaulo);
        return cidadeRepository.salvar(cidade);
    }

    public Cidade obterCidadePorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public boolean verificaCEP(String cep, Long cidadeId) throws IOException {
        Cidade cidade = cidadeRepository.findById(cidadeId);
        if (cidade != null) {
            return cidade.verificaCEP(cep);
        }
        return false;
    }
}
