package lesson10.abstractbigexample;

import java.util.Arrays;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;
    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked;
    private String[] positionsWorked;

    public Employee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, Company[] companiesWorked, String[] positionsWorked) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.curPosition = curPosition;
        this.salaryPerMonth = salaryPerMonth;
        this.companiesWorked = companiesWorked;
        this.positionsWorked = positionsWorked;
    }

    abstract void paySalary();

    void changePosition(String newPosition) {
        if (newPosition == null) {
            System.out.println("Wrong new position");
        }
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory() {
        int index = 0;
        for (String pos : positionsWorked) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        if (bankAccount.getEmployee().equals(this)) {
            this.bankAccount = bankAccount;
        } else {
            System.out.println("Wrong bank account!");
        }

    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", curPosition='" + curPosition + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                ", bankAccount=" + bankAccount +
                ", companiesWorked=" + Arrays.toString(companiesWorked) +
                ", positionsWorked=" + Arrays.toString(positionsWorked) +
                '}';
    }
}
