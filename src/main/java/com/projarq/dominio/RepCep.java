package com.projarq.dominio;

import java.io.IOException;

public interface RepCep {
    boolean verificaCEP(String cep, String nomeCidade) throws IOException;
}
