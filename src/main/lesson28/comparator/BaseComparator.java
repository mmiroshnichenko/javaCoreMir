package main.lesson28.comparator;

public class BaseComparator {

    protected  <T extends  Comparable<T>> Integer compareObjects(T obj1, T obj2, Order order) {
        if (obj1 == null || obj2 == null) {
            if (obj1 == null && obj2 == null) {
                return 0;
            }

            return obj1 == null ? 1 : -1;
        }

        return (order == Order.ASC ? 1 : -1) * obj1.compareTo(obj2);
    }
}
