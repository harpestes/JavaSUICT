package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    private final List<Character> listConsonant = new ArrayList<>(
            Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                          'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'y', 'z')
    );
    private final Map<Character, Character> mapVowel = new HashMap<>() {
        {
            put('1', 'a');
            put('2', 'e');
            put('3', 'i');
            put('4', 'o');
            put('5', 'u');
        }
    };

    public String decode(String s) {
        if (s.isEmpty()) return s;
        StringBuilder result = new StringBuilder();
        Matcher matcher = Pattern.compile("[1-5]").matcher(s);
        if (matcher.find()) {
            for (int i = 0; i < s.length(); i++) {
                if (mapVowel.get(s.toCharArray()[i]) == null) {
                    result.append(s.toCharArray()[i]);
                } else {
                    result.append(mapVowel.get(s.toCharArray()[i]));
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!listConsonant.contains(s.toCharArray()[i])) {
                    result.append(s.toCharArray()[i]);
                } else {
                    if (s.toCharArray()[i] == 'b') {
                        result.append(listConsonant.get(19));
                    } else {
                        result.append(listConsonant.get(listConsonant.indexOf(s.toCharArray()[i]) - 1));
                    }
                }
            }
        }
        return result.toString();
    }
}