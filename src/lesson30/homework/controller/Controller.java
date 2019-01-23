package lesson30.homework.controller;

import lesson30.homework.dao.EmployeeDAO;
import lesson30.homework.dao.ProjectDAO;
import lesson30.homework.entity.Customer;
import lesson30.homework.entity.DepartmentType;
import lesson30.homework.entity.Employee;
import lesson30.homework.entity.Project;

import java.util.ArrayList;
import java.util.Set;

public class Controller {

    public ArrayList<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public Set<Project> projectsByEmployee(Employee employee) {
        return ProjectDAO.projectsByEmployee(employee);
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public ArrayList<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public Set<Employee> employeesByTeamLead(Employee lead) throws Exception {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public Set<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }
}
