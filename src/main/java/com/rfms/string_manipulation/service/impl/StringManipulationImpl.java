package com.rfms.string_manipulation.service.impl;

import com.rfms.string_manipulation.service.StringManipulation;

import java.util.*;

public class StringManipulationImpl implements StringManipulation {
    @Override
    public void countFrequentLetterInsensitive(String text) {
        text = text.replace(" ", "").toLowerCase();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < text.toCharArray().length; i++) {
            char symbol = text.toCharArray()[i];
            frequencyMap.put(symbol, frequencyMap.getOrDefault(symbol, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            String temp = c + "=" + frequencyMap.get(c) ;
            if (!list.contains(temp)) {
                list.add(temp);
            }
        }
        String stringList = list.toString();
        System.out.println(stringList.replace("[","\"").replace("]","\""));
    }

    @Override
    public void countFrequentLetterSensitive(List<String> words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : builder.toString().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        entries.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }

            boolean aIsLower = Character.isLowerCase(a.getKey());
            boolean bIsLower = Character.isLowerCase(b.getKey());
            if (aIsLower != bIsLower) {
                return aIsLower ? 1 : -1;
            }

            return Character.compare(a.getKey(), b.getKey());
        });

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            result.append(entry.getKey());
        }

        System.out.println(result);
    }
}
