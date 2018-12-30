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
