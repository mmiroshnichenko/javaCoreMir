package lesson17.hw1;

public class Solution {
    public int countWords(String input) {
        String[] words = getArrayOfWords(input);
        if (words == null) {
            return 0;
        }

        return words.length;
    }

    private String[] getArrayOfWords(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] strings = input.split(" ");
        int count = 0;

        for (String string : strings) {
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
