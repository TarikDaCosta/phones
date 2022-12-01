package com.tarik.phones;

import java.io.*;
import java.util.*;

public class Main {

    private static HashMap<String, Integer> countCountrys = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        Scanner file = new Scanner(System.in);
        final PhoneNumber phoneNumber = new PhoneNumber();
        countCountrys = sortList(phoneNumber.countCountrys(file.nextLine()));
        CountryCodes countryCodesClass = new CountryCodes();
        countCountrys.forEach((key, value) -> {
            System.out.println(countryCodesClass.namesCodes.get(Integer.valueOf(key)) + ":" + value);
        });
    }

    private static HashMap<String, Integer> sortList(HashMap<String, Integer> countrys) {

        HashMap<String, Integer> order = new LinkedHashMap<String, Integer>();
        countrys.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> order.put(x.getKey(), x.getValue()));

        return order;
    }

}
