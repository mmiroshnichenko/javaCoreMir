package lesson10.abstractbigexample;

public class ManagerEmployee extends Employee{
    public ManagerEmployee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, Company[] companiesWorked, String[] positionsWorked) {
        super(name, age, yearsOfExperience, curPosition, salaryPerMonth, companiesWorked, positionsWorked);
    }

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth();
        newBalance += newBalance * 0.25;
        getBankAccount().setBalance(newBalance);
    }
}
