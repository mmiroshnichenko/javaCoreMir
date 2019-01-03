package lesson17.hw3;

public class Solution {
    public String mostCountedWord(String input) {
        String[] words = input.split(" ");

        String mostCountedWord = null;
        int maxCount = 0;

        for (String word : words) {
            int count = 0;
            for (String compareWord : words) {
                if (!word.isEmpty() && isWord(word) && word.equals(compareWord)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCountedWord = word;
            }
        }

        return mostCountedWord;
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
