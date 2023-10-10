package com.projarq.controller;

import com.projarq.domain.Cidade;
import com.projarq.servicos.ServicosCidade;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/cidades")
public class cidadeController {
    private final ServicosCidade servicosCidade;

    public cidadeController(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String teste() {
        return "devia estar funcionado";
    } 

    @GetMapping("/lista")
    @CrossOrigin(origins = "*")
    public String listarCidades() {
        return servicosCidade.listarCidades().toString();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Cidade obterCidade(@PathVariable Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    @GetMapping("/{id}/verificaCEP")
    @CrossOrigin(origins = "*")
    public boolean verificaCEP(@PathVariable Long id, @RequestParam String cep) throws IOException {
        return servicosCidade.verificaCEP(cep, id);
    }
}
