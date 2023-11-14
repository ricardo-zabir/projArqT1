package com.projarq.dominio.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cidadeOrigem_id")
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidadeDestino_id")
    private Cidade cidadeDestino;

    

    private int peso;
    private double custoTotal;
    private double custoImpostos;
    private double desconto;
    private LocalDate dataOrcamento;

    // Construtor vazio necessário para JPA
    protected Orcamento() {
    }
    // Construtor
    public Orcamento(Long id, Cidade cidadeOrigem, Cidade cidadeDestino, int peso, double custoTotal,
            double custoImpostos, double desconto, LocalDate dataOrcamento) {
        this.id = id;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.peso = peso;
        this.custoTotal = custoTotal;
        this.custoImpostos = custoImpostos;
        this.desconto = desconto;
        this.dataOrcamento = dataOrcamento;
    }

    // getters e setters
    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public int getPeso() {
        return peso;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public double getCustoImpostos() {
        return custoImpostos;
    }

    public double getDesconto() {
        return desconto;
    }

    public LocalDate getDataOrcamento() {
        return dataOrcamento;
    }

    @Override
    public String toString() {

        return "";
    }
}