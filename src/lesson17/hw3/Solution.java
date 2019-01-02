package lesson17.hw3;

public class Solution {

    public String mostCountedWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words.length == 0) {
            return null;
        }

        int[] res = new int[words.length];

//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (i != j && words[i].equals(words[j])) {
//                    res[i]++;
//                }
//            }
//        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
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

        return maxRes > 0 ? mostCounted : null;
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
