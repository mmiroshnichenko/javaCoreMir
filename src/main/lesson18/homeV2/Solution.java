package main.lesson18.homeV2;

public class Solution {
    public int[] findNumbers(String text) {
        String[] strings = text.split(" ");
        int count = 0;
        for (String string : strings) {
            if (!string.isEmpty() && isNumber(string)) {
                count++;
            }
        }

        int[] numbers = new int[count];
        int index = 0;
        for (String string : strings) {
            if (string.isEmpty())
                continue;

            if (isNumber(string)) {
                numbers[index] = Integer.parseInt(string);
                index++;
            } else {
                System.out.println("not a number");
            }
        }

        return numbers;
    }

    private boolean isNumber(String string) {
        char[] digits = string.toCharArray();

        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }

        return true;
    }
}
