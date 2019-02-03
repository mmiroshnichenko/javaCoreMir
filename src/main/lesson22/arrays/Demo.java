package main.lesson22.arrays;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 9, 5, 4, 0, 0 ,0};

        System.out.println(ArrayUtils.nCount(array, 4));
        System.out.println(ArrayUtils.nCount(array, 0));
        System.out.println(ArrayUtils.nCount(array, -1));

        System.out.println(ArrayUtils.maxElement(array));
        System.out.println(Arrays.toString(ArrayUtils.sortAscending(array)));
        System.out.println(Arrays.toString(ArrayUtils.sortDescending(array)));

        int[] array2 = {-10, 4, 6, -9, 5, 4, -3, 0 ,12};
        System.out.println(ArrayUtils.maxElement(array2));
        System.out.println(Arrays.toString(ArrayUtils.sortAscending(array2)));
        System.out.println(Arrays.toString(ArrayUtils.sortDescending(array2)));
    }

}
