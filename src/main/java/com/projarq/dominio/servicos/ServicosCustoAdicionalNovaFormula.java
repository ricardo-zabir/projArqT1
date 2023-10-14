package com.projarq.dominio.servicos;


import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

@Service
@Primary
public class ServicosCustoAdicionalNovaFormula implements InterfaceServicosCustoAdicional {
    public ServicosCustoAdicionalNovaFormula(){
        
    }

    public double getAdicionalPorPeso(int gramas) {
        int emKg = (int) (Math.ceil(gramas / 1000.00));
        double adicionalPorPeso = 0.00;
        if(emKg > 5) {
            if(emKg <= 20) {
                adicionalPorPeso = (emKg - 5) * 10.00;
            }
            if(emKg > 20){
                adicionalPorPeso = (emKg - 5) * 10.00;
                int excedente = emKg - 20;
                adicionalPorPeso += (excedente / 5) * 20.00;
            }
        }
        return adicionalPorPeso;
    }
}

