package lesson30.homework.entity;

import java.util.Set;
import java.util.TreeSet;

public class Department {
    private DepartmentType type;
    Set<Employee> employees = new TreeSet<>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) throws Exception {
        if (employees.add(employee)) {
            return employee;
        }

        throw new Exception("Error: " + employee + " already exist in " + this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employeesCount=" + employees.size() +
                '}';
    }
}
