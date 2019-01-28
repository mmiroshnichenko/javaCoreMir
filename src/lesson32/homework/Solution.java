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

        for (int i = 0; i < 3; i++) {
            try {
                int sum = 0;
                String[] txtNumbers = br.readLine().split(" ");
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
                br.close();

                return sum;
            } catch (Exception e) {
                System.out.println("Your numbers are wrong. You have " + (2 - i) + " attempts to try again");
            }
        }

        System.out.println("Your numbers are wrong. Number of attempts exceeded");
        br.close();

        return 0;
    }
}
