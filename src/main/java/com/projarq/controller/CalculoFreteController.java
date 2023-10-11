package com.projarq.controller;
import com.projarq.aplicacao.ValidaCEP_UC;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.aplicacao.ListaCidades_UC;
import com.projarq.aplicacao.CalculaOrcamento_UC;


@RestController
public class CalculoFreteController {
    private final ValidaCEP_UC validaCEP_UC;
    private final ListaCidades_UC listaCidades_UC;
    private final CalculaOrcamento_UC teste;
    public CalculoFreteController(ValidaCEP_UC validaCEP_UC, ListaCidades_UC listaCidades_UC, CalculaOrcamento_UC teste){
        this.listaCidades_UC=listaCidades_UC;
        this.validaCEP_UC=validaCEP_UC;
        this.teste=teste;
    }

    @GetMapping("/cidadesatendidas")
    public ResponseEntity<List<String>> listaCidades(){
        List<String> lista = listaCidades_UC.run();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/validacep")
    public ResponseEntity<Boolean> validaCEP(@RequestParam String cep) throws IOException{
        Boolean resposta = validaCEP_UC.run(cep);

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    //exemplo pra teste: http://localhost:8080/calculafrete?origem=1&destino=2&gramas=15000
    @GetMapping("/calculafrete")
    public ResponseEntity<Double> calculaFrete(@RequestParam Long origem, @RequestParam Long destino, @RequestParam int gramas){
        Double resposta = teste.run(origem, destino, gramas);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }


}
