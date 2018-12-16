package lesson10.abstractbigexample;

public class DeveloperEmployee extends Employee{
    private String[] frameworks;

    public DeveloperEmployee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, Company[] companiesWorked, String[] positionsWorked, String[] frameworks) {
        super(name, age, yearsOfExperience, curPosition, salaryPerMonth, companiesWorked, positionsWorked);
        this.frameworks = frameworks;
    }

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
