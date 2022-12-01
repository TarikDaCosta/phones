package com.tarik.phones;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class PhoneNumber {

    private boolean isValid;
    private String code;


    public PhoneNumber () {

    }

    public HashMap<String, Integer> countCountrys(String file) throws IOException {

        HashMap<String, Integer> countCountrys = new HashMap<String, Integer>();
        InputStream stream = getClass().getResourceAsStream(file);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while(linha != null) {
            final PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.validate(linha);
            if (phoneNumber.isValid) {
                countCountrys.merge(phoneNumber.code, 1, Integer::sum);
            }
            linha = br.readLine();
        }
        return countCountrys;
    }

    public void validate(String number) {

        if ((number.length() > 3) && (number.length() < 7)) {
            this.validateShortNumber(number);
        } else {
            this.validateLongNumber(number);
        }

    }

    private void validateLongNumber(String number) {
        this.isValid = true;

        if (number.charAt(0) == '+') {
            number = number.replace("+", "");
        } else if (number.substring(0, 2).equals("00")) {
            number = number.replace("00", "");
            number = "351 " + number;
        }

        if (number.charAt(0) == ' ') {
            this.isValid = false;
        }

        this.code = number.substring(0, number.indexOf(" "));

        number = number.replaceAll(" ", "");
        if ((number.length() > 8) && (number.length() < 15)) {
            if (!Pattern.matches("[0-9]+", number)) {
                this.isValid = false;
            }
        } else {
            this.isValid = false;
        }
    }

    private void validateShortNumber(String number) {
        this.isValid = true;

        if (number.charAt(0) == '0') {
            this.isValid = false;
        }

        if (number.replaceAll(" ", "").length() != number.length()) {
            this.isValid = false;
        }

        if (!Pattern.matches("[0-9]+", number)) {
            this.isValid = false;
        }

        this.code = "351";
    }
}
