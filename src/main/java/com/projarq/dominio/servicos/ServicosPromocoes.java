package com.projarq.dominio.servicos;

import com.projarq.dominio.entidades.Cidade;

public class ServicosPromocoes {
    
    public double calculaDesconto(Cidade cidadeOrigem, Cidade cidadeDestino, int kg, double valor) {
        double desconto = 0.00;
        if (cidadeOrigem.getNome().equals("Porto Alegre")) {
            desconto += valor * 0.03;
        }
        return desconto;
    }
}
