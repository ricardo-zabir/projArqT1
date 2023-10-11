package com.projarq.aplicacao;
import com.projarq.dominio.servicos.ServicosCidade;

import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ValidaCEP_UC{
    private final ServicosCidade servicosCidade;

    public ValidaCEP_UC(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    public boolean run(String cep) throws IOException {
        return servicosCidade.verificaCEP(cep)? true : false;
    }
}
