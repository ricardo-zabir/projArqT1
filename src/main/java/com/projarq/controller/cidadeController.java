package com.projarq.controller;

import com.projarq.domain.Cidade;
import com.projarq.servicos.ServicosCidade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Controller
@RestController
@RequestMapping("/cidades")
public class cidadeController {
    private final ServicosCidade servicosCidade;

    public cidadeController(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    @GetMapping("")
    public String listarCidades() {
        return "ola mundo";
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
