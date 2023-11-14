package com.projarq.controller;

import com.projarq.aplicacao.ValidaCEP_UC;
import com.projarq.dominio.entidades.Orcamento;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.aplicacao.ListaCidades_UC;
import com.projarq.aplicacao.CalculaOrcamento_UC;
import com.projarq.aplicacao.ListaOrcamentosPorData_UC;
import com.projarq.aplicacao.RetornaPromoVigente_UC;

@RestController
public class CalculoFreteController {
    private final ValidaCEP_UC validaCEP_UC;
    private final ListaCidades_UC listaCidades_UC;
    private final CalculaOrcamento_UC calculaOrcamento_UC;
    private final ListaOrcamentosPorData_UC listaOrcamentosPorData_UC;
    private final RetornaPromoVigente_UC retornaPromoVigente_UC;

    public CalculoFreteController(ListaOrcamentosPorData_UC listaOrcamentosPorData_UC) { // Correção aqui
        this.listaOrcamentosPorData_UC = listaOrcamentosPorData_UC;
    }

    @GetMapping("/listaorcamentospordata")
    public ResponseEntity<List<Orcamento>> listaOrcamentosPorData(@RequestParam LocalDate data) {
        List<Orcamento> resposta = listaOrcamentosPorData_UC.run(data);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
