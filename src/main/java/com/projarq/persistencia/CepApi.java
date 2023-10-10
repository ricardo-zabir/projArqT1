package com.projarq.persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.stereotype.Service;

import com.projarq.dominio.repositorios.RepCep;

@Service
public class CepApi implements RepCep {
    public boolean verificaCEP(String cep, String nomeCidade) throws IOException {
        cep = cep.replace("-", "");
        cep = cep.replace(".", "");
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        StringBuilder jsont = new StringBuilder();
        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            jsont.append(linha);
        }
        String json = jsont.toString();
        String nomeCidadeAPI = json.substring(json.indexOf("localidade") + 14, json.indexOf("localidade") + 14 + json.substring(json.indexOf("localidade") + 14).indexOf("\""));

        return nomeCidadeAPI.equalsIgnoreCase(nomeCidade);
    }
}
