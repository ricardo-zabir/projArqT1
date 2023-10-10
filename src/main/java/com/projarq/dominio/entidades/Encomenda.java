package com.projarq.dominio.entidades;
import java.util.Date;

public class Encomenda {

    private Date dataHora;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private int pesoGramas;
    private double custoBasico;
    private double custoAdicional;
    private double valorImpostos;
    private double desconto;
    private double valorFinal;

    // Construtor
    public Encomenda(Cidade cidadeOrigem, Cidade cidadeDestino, int pesoGramas) {
        this.dataHora = new Date();
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.pesoGramas = pesoGramas;
        custoBasico = calcularCustoBasico();
        calcularCustoAdicional();
        calcularImpostos();
        calcularDesconto();
        calcularValorFinal();
    }

    // Métodos para cálculos
    private double calcularCustoBasico() {
        // Defina aqui a tabela de custo básico para São Paulo e outras cidades
        // Exemplo:
        double custo=0;
        if (cidadeDestino.getNome().equalsIgnoreCase("São Paulo ")) {
            custoBasico = cidadeOrigem.getCustoBasicoParaSaoPaulo();
        } else {
            custo = cidadeOrigem.getCustoBasicoParaSaoPaulo() + cidadeDestino.getCustoBasicoParaSaoPaulo();
        }
        return custo;
    }

    private void calcularCustoAdicional() {
    }

    private void calcularImpostos() {

    }

    private void calcularDesconto() {
    
    }

    private void calcularValorFinal() {

    }


    @Override
    public String toString() {
        
        return "";
    }
}
