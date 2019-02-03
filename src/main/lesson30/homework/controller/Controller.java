package main.lesson30.homework.controller;

import main.lesson30.homework.dao.EmployeeDAO;
import main.lesson30.homework.dao.ProjectDAO;
import main.lesson30.homework.entity.Customer;
import main.lesson30.homework.entity.DepartmentType;
import main.lesson30.homework.entity.Employee;
import main.lesson30.homework.entity.Project;

import java.util.ArrayList;
import java.util.Set;

public class Controller {

    public static ArrayList<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public static Set<Project> projectsByEmployee(Employee employee) {
        return ProjectDAO.projectsByEmployee(employee);
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public static Set<Employee> employeesByTeamLead(Employee lead) throws Exception {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public static Set<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }
}
