package lesson34.homework2;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.transferSentences(
                    "C:\\Users\\miroshnichenko\\Desktop\\test.txt",
                      "C:\\Users\\miroshnichenko\\Desktop\\test1.txt",
                         "test"
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
