package lesson18.homeV1;

public class Solution {
    public int[] findNumbers(String text) {
        String[] strings = text.split(" ");

        int[] numbers = new int[strings.length];
        int count = 0;
        for (String string : strings) {
            if (string.isEmpty()) {
                continue;
            }

            try {
                numbers[count] = Integer.parseInt(string);
                count++;
            } catch (Exception e) {
                System.out.println("not a number");
            }
        }

        int[] resNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            resNumbers[i] = numbers[i];
        }

        return resNumbers;
    }
}
