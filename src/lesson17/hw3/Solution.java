package lesson17.hw3;

public class Solution {

    public String mostCountedWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null || words.length == 0) {
            return null;
        }

        int[] res = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i !=j && words[i].equals(words[j])) {
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

        if (maxRes > 0) {
            return mostCounted;
        }

        return null;
    }

    private String[] getArrayOfWords(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");
        int count = 0;

        for (String string : strings) {
            string = string
                    .replace(',', ' ')
                    .replace('!', ' ')
                    .replace(';', ' ')
                    .replace(':', ' ')
                    .replace('?', ' ')
                    .replace('-', ' ')
                    .replace('.', ' ')
                    .trim();
            if (!string.isEmpty() && isWord(string)) {
                count++;
            }
        }

        if (count == 0) {
            return null;
        }

        String[] words = new String[count];
        int index = 0;
        for (String string : strings) {
            string = string
                    .replace(',', ' ')
                    .replace('!', ' ')
                    .replace(';', ' ')
                    .replace(':', ' ')
                    .replace('?', ' ')
                    .replace('-', ' ')
                    .replace('.', ' ')
                    .trim();
            if (!string.isEmpty() && isWord(string)) {
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
