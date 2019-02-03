package main.lesson21;

public class Company {

    private int numberOfEmployee;
    private String name;
    private static String licence;
    private static int maxNumberOfEmployees = 100;

     static {
        System.out.println("Code block is called");
        init();
    }

    public Company(int numberOfEmployee, String name) throws Exception {
        if (numberOfEmployee > maxNumberOfEmployees) {
            throw new Exception("Company can have " + maxNumberOfEmployees + " employees");
        }
        this.numberOfEmployee = numberOfEmployee;
        this.name = name;
    }

    private static void init() {
        maxNumberOfEmployees = 100;
    }

    public static void validate() throws Exception{
        if (!licence.equals("TTT111")) {
            throw new Exception("Wrong licence" + licence);
        }
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public String getName() {
        return name;
    }

    public String getLicence() {
        return licence;
    }

    public static void setLicence(String licence) {
        Company.licence = licence;
    }

    private static class Test {

    }
}
