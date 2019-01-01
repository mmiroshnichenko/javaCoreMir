package lesson16.home;

import java.util.Arrays;

public class Solution {
    public int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] strings = input.split(" ");

        int count = 0;
        for (String string : strings) {
            if (isWord(string)) {
                count++;
            }
        }

        return count;
    }

    public String maxWord(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");

        String maxWord = strings[0];

        for (String string : strings) {
            if (string.length() > maxWord.length()) {
                maxWord = string;
            }
        }

        return maxWord;
    }

    public String minWord(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");

        String minWord = strings[0];

        for (String string : strings) {
            if (string.length() < minWord.length()) {
                minWord = string;
            }
        }

        return minWord;
    }

    public String mostCountedWord(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");

        int[] res = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    res[i]++;
                }
            }
        }

        int maxRes = res[0];
        String mostCounted = strings[0];

        for (int i = 1; i < strings.length; i++) {
            if (res[i] > maxRes) {
                maxRes = res[i];
                mostCounted = strings[i];
            }
        }

        if (maxRes > 1) {
            return mostCounted;
        }

        return null;
    }

    public boolean validate(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }

        String[] parts = address.split("//");
        if (parts.length != 2 || (!parts[0].equals("http:") && !parts[0].equals("https:"))) {
            return false;
        }

        String[] addressParts = parts[1].split("\\.");
        String siteName;
        String domain;

        if (addressParts.length == 3 && addressParts[0].equals("www")) {
            siteName = addressParts[1];
            domain = addressParts[2];
        } else if (addressParts.length == 2) {
            siteName = addressParts[0];
            domain = addressParts[1];
        } else {
            return false;
        }

        if (siteName == null || domain == null || !validateAddressPart(siteName)
                || (!domain.equals("com") && !domain.equals("org") && !domain.equals("net"))) {
            return false;
        }

        return true;
    }

    private boolean validateAddressPart(String addressPart) {
        char[] chars = addressPart.toCharArray();

        for (char ch : chars) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    private boolean isWord(String string) {
        char[] letters = string.toCharArray();
        /*String[] symbols = new String[]{"!", ";", ":", "?", "-", ",", "."};*/

        for (char letter : letters) {
            if (!Character.isLetter(letter) /*&& !Arrays.asList(symbols).contains(new String(new char[]{letter}))*/) {
                return false;
            }
        }

        return true;
    }
}
