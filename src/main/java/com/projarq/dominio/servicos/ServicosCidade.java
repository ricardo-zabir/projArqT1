package com.projarq.dominio.servicos;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.repositorios.RepCidade;
import com.projarq.persistencia.CepApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosCidade {
    @Autowired
    private final RepCidade RepCidade;
    private final CepApi cepApi;

    public ServicosCidade(RepCidade RepCidade, CepApi cepApi) {
        this.RepCidade = RepCidade;
        this.cepApi = cepApi;
    }

    public List<Cidade> listarCidades() {
        return RepCidade.findAll();
    }

    public Cidade criarCidade(Long id, String nome, double custoBasicoParaSaoPaulo) {
        Cidade cidade = new Cidade(id,nome, custoBasicoParaSaoPaulo);
        return RepCidade.salvar(cidade);
    }

    public Cidade obterCidadePorId(Long id) {
        return RepCidade.findById(id);
    }

    public Cidade obterCidadePorCep(String cep) throws IOException {
        //crie a implementacao de obtercidadeporCep que use verifica cep
        for (Cidade cidade : listarCidades().stream().collect(Collectors.toList())) {
            String cidadeCep = cepApi.verificaCEP(cep);
            if (cidade.getNome().equalsIgnoreCase(cidadeCep)) {
                return cidade;
            }
        }
        return null;
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
