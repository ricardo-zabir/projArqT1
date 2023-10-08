package com.projarq.controller;

import com.projarq.domain.Cidade;
import com.projarq.servicos.ServicosCidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@RestController
@RequestMapping("/cidades")
public class cidadeController {
    private final ServicosCidade servicosCidade;

    @Autowired
    public cidadeController(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    @PostMapping
    public Cidade criarCidade(@RequestParam String nome, @RequestParam double custoBasicoParaSaoPaulo) {
        Long id=1L;
        return servicosCidade.criarCidade(id,nome, custoBasicoParaSaoPaulo);
    }

    @GetMapping("/{id}")
    public Cidade obterCidade(@PathVariable Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    @GetMapping("/{id}/verificaCEP")
    public boolean verificaCEP(@PathVariable Long id, @RequestParam String cep) throws IOException {
        return servicosCidade.verificaCEP(cep, id);
    }
}
