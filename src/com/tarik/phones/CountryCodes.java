package com.tarik.phones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountryCodes {

    public HashMap<Integer, String> namesCodes = new HashMap<Integer, String>();

    public CountryCodes() throws IOException {
        this.loadCountryCodes();
    }

    private void loadCountryCodes() throws IOException {

        InputStream stream = getClass().getResourceAsStream("coutryCodes.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while(linha != null) {
            namesCodes.put(Integer.valueOf(linha.substring(linha.indexOf("-")+1)),
                    linha.substring(0, linha.indexOf("-")));
            linha = br.readLine();
        }
    }
}
