package lesson9.company;

public class Employee {
    String name;
    Company company;
    int monthlySalary;

    public Employee(String name, Company company, int monthlySalary) {
        this.name = name;
        this.company = company;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company=" + company +
                ", monthlySalary=" + monthlySalary +
                '}';
    }
}
