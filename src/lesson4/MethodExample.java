package lesson4;

public class MethodExample {

    public static void main(String[] args) {
        System.out.println(increaser(5, 20));
        System.out.println(min(increaser(10, 5), 11));

        System.out.println(concat("First ", "Second ", "Third"));

        //System.out.println(findDivCount(2, 10, 5));
        System.out.println(compareSums(2,5, 3, 10));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return sum(a, b) > sum(c, d);
    }

    public static int sum(int from, int to) {
        int sum = 0;

        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }

    public static int findDivCount(short a, short b, int n) {
        if (n == 0) {
            System.out.println("Error: Div by zero");
            return 0;
        }
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                count++;
            }
        }
        return count;
    }

    public static String concat(String first, String second, String third) {
        String res = "";
        String[] words = {first, second, third};
        for (String word : words) {
            if (word != null) {
                res += word;
            }
        }
        return res;
    }

    public static int increaser(int a, int index) {
        System.out.println("method invoked");
        a += index;
        System.out.println("method before return");
        return a;
    }

    public static int min(int a, int b) {
//        if (a < b) {
//            return a;
//        } else {
//            return b;
//        }
        return a < b ? a : b;
    }
}
