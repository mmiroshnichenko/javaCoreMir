package lesson32.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int readNumbers() throws IOException {
        //using scanner
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter numbers in line");

        int attempts = 3;
        String input;
        int sum = 0;
        while ((input = br.readLine()) != null) {
            try {
                String[] txtNumbers = input.split(" ");
                if (txtNumbers.length != 10) {
                    throw new Exception("Error: count of numbers must be equals 10");
                }
                for (String txtNumber : txtNumbers) {
                    int number = Integer.parseInt(txtNumber);
                    if (number > 100) {
                        throw new Exception("Error: number cannot be more than 100");
                    }
                    sum += number;
                }
                break;
            } catch (Exception e) {
                attempts--;
                if (attempts <= 0) {
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    break;
                }
                System.out.println("Your numbers are wrong. You have " + attempts + " attempts to try again");
            }
        }

        br.close();

        return sum;
    }
}
