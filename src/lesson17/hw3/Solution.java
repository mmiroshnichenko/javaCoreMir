package lesson17.hw3;

public class Solution {
    public String mostCountedWord(String input) {
        String[] words = input.split(" ");
        if (words.length == 0) {
            return null;
        }

        String mostCountedWord = words[0];
        int maxCount = 0;

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = i; j < words.length; j++) {
                if (!words[i].isEmpty() && isWord(words[i]) && words[i].equals(words[j])) {
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
