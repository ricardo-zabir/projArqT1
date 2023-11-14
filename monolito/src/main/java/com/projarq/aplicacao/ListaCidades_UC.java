package com.projarq.aplicacao;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.servicos.ServicosCidade;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListaCidades_UC{
    private final ServicosCidade servicosCidade;

    public ListaCidades_UC(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    public List<String> run() {
        return servicosCidade.listarCidades().stream().map(Cidade::getNome).collect(Collectors.toList());
    }


}
