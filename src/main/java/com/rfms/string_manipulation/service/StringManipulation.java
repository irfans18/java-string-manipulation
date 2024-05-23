package com.rfms.string_manipulation.service;

import java.util.List;

public interface StringManipulation {
    void countFrequentLetterInsensitive(String text);

    void countFrequentLetterSensitive(List<String> texts);
}
