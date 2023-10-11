package com.projarq.dominio.servicos;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.persistencia.CepApi;
import com.projarq.persistencia.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosCidade {
    @Autowired
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

    public boolean verificaCEP(String cep) throws IOException {
        if (cep != null) {
            String cidadeCep = cepApi.verificaCEP(cep);
            for (String cidade : listarCidades().stream().map(Cidade::getNome).collect(Collectors.toList())) {
                if (cidadeCep.equalsIgnoreCase(cidade)) {
                    return true;
                }
            }
        }
        return false;
    }
}
