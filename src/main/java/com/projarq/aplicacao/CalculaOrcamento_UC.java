package com.projarq.aplicacao;

import java.io.IOException;

import org.springframework.stereotype.Component;

//import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.servicos.ServicosOrcamento;
@Component
public class CalculaOrcamento_UC {
    private final ServicosOrcamento servicosOrcamento;
    public CalculaOrcamento_UC(ServicosOrcamento servicosOrcamento){
        this.servicosOrcamento = servicosOrcamento;
    }

    public double run(String origem, String destino, int gramas) throws IOException{
        return servicosOrcamento.calcularPrecoDeNovaEncomenda(origem, destino, gramas);
    }
}
