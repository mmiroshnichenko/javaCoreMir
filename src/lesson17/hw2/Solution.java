package lesson17.hw2;

public class Solution {
    public String maxWord(String input) {
        String[] words = input.split(" ");
        String maxWord = null;
        int maxCount = 0;
        for (String word : words) {
            if (!word.isEmpty() && isWord(word) && word.length() > maxCount) {
                maxWord = word;
                maxCount = word.length();
            }
        }

        return maxWord;
    }

    public String minWord(String input) {
        String[] words = input.split(" ");
        String minWord = null;
        int minCount = -1;
        for (String word : words) {
            if (!word.isEmpty() && isWord(word) && (minCount == -1 || word.length() < minCount)) {
                minWord = word;
                minCount = word.length();
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
