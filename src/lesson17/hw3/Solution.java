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
            for (int j = i + 1; j < words.length; j++) {
                if (i != j && !words[i].isEmpty() && words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCountedWord = words[i];
            }
        }

        return mostCountedWord;
    }
}
