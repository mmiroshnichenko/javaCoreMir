package main.lesson34.homework3;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.copyFileContent(
                    "C:\\Users\\miroshnichenko\\Desktop\\test.txt",
                    "C:\\Users\\miroshnichenko\\Desktop\\test1.txt"
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
