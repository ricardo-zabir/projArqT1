package com.projarq.dominio.servicos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.projarq.dominio.entidades.Cidade;

@Service
@Primary
public class ServicoImposto implements InterfaceServicosImposto{
    public ServicoImposto() {
    }

    public double getImposto(double precoBasico, Cidade cidadeOrigem) {
        if (cidadeOrigem.getNome().equals("Porto Alegre")) {
            double imposto = precoBasico * 0.03;
            return imposto;
        }
        else if(cidadeOrigem.getNome().equals("São Paulo")) {
            double imposto = precoBasico * 0.04;
            return imposto;
        }
        else {
            double imposto = precoBasico * 0.05;
            return imposto;
        }
    }
}
