package com.projarq.dominio.servicos;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.projarq.dominio.entidades.Cidade;

@Primary
@Service
public class ServicosPromocoes {
    
    public double calculaDesconto(Cidade cidadeOrigem, Cidade cidadeDestino, int gramas, double valor) {
        double desconto = 0.00;
        if (cidadeOrigem.getNome().equals("Porto Alegre") && gramas >= 10000) {
            desconto += valor * 0.05;
        }
        if(cidadeOrigem.getNome().equals("São Paulo") && (cidadeDestino.getNome().equals("Curitiba") || cidadeDestino.getNome().equals("Florianópolis"))) {
            desconto += valor * (gramas / 1000 * 0.01);
        }
        return desconto;
    }

    public String retornaPromoVigente () {
        return "As seguintes promoções estão vigentes \n: toda encomenda que sai de Porto Alegre e tem mais de 10kg recebe 5% de desconto do valor total \n;"
        + "Para encomendas que saem de São Paulo e vão para Curitiba ou Florianópolis há um desconto de 1% por kg da encomenda \n";
    }
}
