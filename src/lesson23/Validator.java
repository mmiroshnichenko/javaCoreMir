package lesson23;

public final class Validator {

    private String name;
    private final static int checkCount = 7;

    public Validator(String name) {
        this.name = name;
    }

    public final boolean validate() {
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}
