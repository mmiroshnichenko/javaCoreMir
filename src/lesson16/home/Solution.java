package lesson16.home;

public class Solution {
    public int countWords(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null) {
            return 0;
        }

        int count = 0;
        for (String word : words) {
            if (isWord(word)) {
                count++;
            }
        }

        return count;
    }

    public String maxWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null || words.length == 0) {
            return null;
        }
        String maxWord = words[0];

        for (String word : words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }

        return maxWord;
    }

    public String minWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null || words.length == 0) {
            return null;
        }

        String minWord = words[0];

        for (String word : words) {
            if (word.length() < minWord.length()) {
                minWord = word;
            }
        }

        return minWord;
    }

    public String mostCountedWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null) {
            return null;
        }

        int[] res = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    res[i]++;
                }
            }
        }

        int maxRes = res[0];
        String mostCounted = words[0];

        for (int i = 1; i < words.length; i++) {
            if (res[i] > maxRes) {
                maxRes = res[i];
                mostCounted = words[i];
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

    private String[] getArrayOfWords(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");
        int count = 0;

        for (String string : strings) {
            if (!string.isEmpty()) {
                count++;
            }
        }

        if (count == 0) {
            return null;
        }

        String[] words = new String[count];
        int index = 0;
        for (String string : strings) {
            if (!string.isEmpty()) {
                words[index] = string;
                index++;
            }
        }

        return words;
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
