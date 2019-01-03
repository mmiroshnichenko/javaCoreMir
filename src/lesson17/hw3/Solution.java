package lesson17.hw3;

public class Solution {
    public String mostCountedWord(String input) {
        String[] words = input.split(" ");

        String mostCountedWord = words[0];
        int maxCount = 0;

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (i != j && !words[i].isEmpty() && words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCountedWord = words[i];
            }
        }

        return maxCount > 0 ? mostCountedWord : null;
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
