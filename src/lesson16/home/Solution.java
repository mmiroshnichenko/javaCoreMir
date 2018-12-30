package lesson16.home;

public class Solution {
    public int countWords(String input) {
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
        String[] strings = input.split(" ");

        String minWord = strings[0];

        for (String string : strings) {
            if (string.length() < minWord.length()) {
                minWord = string;
            }
        }

        return minWord;
    }

    private boolean isWord(String string) {
        char[] letters = string.toCharArray();

        for (char letter : letters) {
           if (!Character.isLetter(letter)) {
               return false;
           }
        }

        return true;
    }
}
