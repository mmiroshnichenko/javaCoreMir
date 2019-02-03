package main.lesson30.homework.dao;

import main.lesson30.homework.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    private static Set<Employee> employees = new HashSet<>();

    public static Employee add(Employee employee) throws Exception {
        if (employees.add(employee)) {
            return employee;
        }

        throw new Exception("Error: " + employee + " already exist in base");
    }

    public static Set<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Employee> employeesByProject(String projectName) {
        ArrayList<Employee> employeesArrayList = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.getName().equals(projectName)) {
                    employeesArrayList.add(employee);
                    break;
                }
            }
        }

        return employeesArrayList;
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        Department department = DepartmentDAO.getDepartmentByType(departmentType);
        ArrayList<Employee> employeesArrayList = new ArrayList<>();

        for (Employee employee : department.getEmployees()) {
            if (employee.getProjects().isEmpty()) {
                employeesArrayList.add(employee);
            }
        }

        return employeesArrayList;
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> employeesArrayList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getProjects().isEmpty()) {
                employeesArrayList.add(employee);
            }
        }

        return employeesArrayList;
    }

    public static Set<Employee> employeesByTeamLead(Employee lead) throws Exception {
        if (!lead.getPosition().equals(Position.TEAM_LEAD)) {
            throw new Exception("Error: " + lead + " is not team lead");
        }

        return employeesByProjectEmployee(lead);
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> leadsSet = new HashSet<>();

        for (Employee otherEmployee : getAllEmployeesByProjects(employee.getProjects())) {
            if (otherEmployee.getPosition().equals(Position.TEAM_LEAD)) {
                leadsSet.add(otherEmployee);
            }
        }

        return leadsSet;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employeesSet = getAllEmployeesByProjects(employee.getProjects());
        employeesSet.remove(employee);

        return employeesSet;
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        return getAllEmployeesByProjects(ProjectDAO.projectsByCustomer(customer));
    }

    private static Set<Employee> getAllEmployeesByProjects(Set<Project> projects) {
        Set<Employee> employeesSet = new HashSet<>();

        for (Project project : projects) {
            employeesSet.addAll(employeesByProject(project.getName()));
        }

        return employeesSet;
    }
}
