package com.rfms.string_manipulation;

import com.rfms.string_manipulation.service.StringManipulation;
import com.rfms.string_manipulation.service.impl.StringManipulationImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringManipulation service = new StringManipulationImpl();
        service.countFrequentLetterInsensitive("We Always Mekar");
        service.countFrequentLetterInsensitive("coding is fun");
        service.countFrequentLetterSensitive(Arrays.asList("Abc", "bCd"));
        service.countFrequentLetterSensitive(Arrays.asList("Oke", "One"));
        service.countFrequentLetterSensitive(Arrays.asList("Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"));
    }
}