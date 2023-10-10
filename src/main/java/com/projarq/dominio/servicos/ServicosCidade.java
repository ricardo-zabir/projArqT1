package com.projarq.dominio.servicos;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.persistencia.CepApi;
import com.projarq.persistencia.CidadeRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ServicosCidade {
    private final CidadeRepository cidadeRepository;
    private final CepApi cepApi;

    public ServicosCidade(CidadeRepository cidadeRepository, CepApi cepApi) {
        this.cidadeRepository = cidadeRepository;
        this.cepApi = cepApi;
    }

    public List<Cidade> listarCidades() {
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
            return cepApi.verificaCEP(cep,cidade.getNome())? true : false;
        }
        return false;
    }
}
