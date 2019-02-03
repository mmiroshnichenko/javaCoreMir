package main.lesson25.homework;

public class GeneralDAO<T> {
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {
        for (T el : array) {
            if (t.equals(el)) {
                throw new Exception("Object: " + t.toString() + " already exist");
            }
        }

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        throw new Exception("Base is full");
    }

    public T[] getAll() {
        int count = 0;
        for (T el : array) {
            if (el != null) {
                count++;
            }
        }

        @SuppressWarnings("unchecked")
        T[] res = (T[]) new Object[count];

        int index = 0;
        for (T el : array) {
            if (el != null) {
                res[index] = el;
                index++;
            }
        }

        return res;
    }
}
