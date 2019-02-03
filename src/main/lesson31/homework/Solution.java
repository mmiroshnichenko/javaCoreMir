package main.lesson31.homework;

import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static TreeMap<Character, Integer> countSymbols(String text) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (char ch : text.toCharArray()) {
            map.put(ch,  map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        return map;
    }

    public static HashMap<String, Integer> words(String text) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : text.split(" ")) {
            if (word.length() > 2) {
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }
        }

        return map;
    }
}
