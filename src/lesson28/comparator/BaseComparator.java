package lesson28.comparator;

public class BaseComparator {

    protected  <T> Integer compareObjectsWithNull(T obj1, T obj2) {
        if (obj1 == null || obj2 == null) {
            if (obj1 == null && obj2 == null) {
                return 0;
            }

            return obj1 == null ? 1 : -1;
        }

        return null;
    }
}
