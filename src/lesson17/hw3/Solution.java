package lesson17.hw3;

public class Solution {

    public String mostCountedWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words.length == 0) {
            return null;
        }

        String mostCountedWord = words[0];
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < words.length; i++) {
            count = 0;
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].equals(words[j])) {
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

    private String[] getArrayOfWords(String input) {
        String[] strings = input.split(" ");
        int count = 0;

        for (String string : strings) {
            if (!string.isEmpty() && isWord(string)) {
                count++;
            }
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

        for (char letter : letters) {
            if (!Character.isLetter(letter)) {
                return false;
            }
        }

        return true;
    }
}
