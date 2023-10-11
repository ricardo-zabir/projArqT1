package com.projarq.dominio.servicos;

import org.springframework.stereotype.Service;

@Service
public class ServicosCustoAdicional {

    public ServicosCustoAdicional(){
        
    }

    public double getAdicionalPorPeso(int gramas) {
        int emKg = (int) (Math.ceil(gramas / 1000.00));
        double adicionalPorPeso = 0.00;
        if(emKg >= 2) {
            if(emKg >= 12) {
                adicionalPorPeso = (emKg - 2) * 10.00;
            }
            if(emKg > 12){
                adicionalPorPeso = 100 + (15.00 * (emKg - 12));
            }
        }
        return adicionalPorPeso;
    }
}
