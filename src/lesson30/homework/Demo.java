package lesson30.homework;

import lesson30.homework.controller.Controller;
import lesson30.homework.dao.DepartmentDAO;
import lesson30.homework.dao.EmployeeDAO;
import lesson30.homework.dao.ProjectDAO;
import lesson30.homework.entity.*;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Customer customer1 = new Customer("customer1", "Ukraine", 1000);
        Customer customer2 = new Customer("customer2", "Ukraine", 2000);
        Customer customer3 = new Customer("customer3", "USA", 3000);

        Project project1 = new Project("project1", customer1);
        Project project2 = new Project("project2", customer2);
        Project project3 = new Project("project3", customer3);

        Department departmentDevelopment = new Department(DepartmentType.DEVELOPMENT);
        Department departmentFinance = new Department(DepartmentType.FINANCE);
        Department departmentDesign = new Department(DepartmentType.DESIGN);

        Employee employee1 = new Employee("FirstName1", "LastName1", new Date(), Position.TEAM_LEAD, departmentDevelopment);
        Employee employee2 = new Employee("FirstName2", "LastName2", new Date(), Position.DEVELOPER, departmentDevelopment);
        Employee employee3 = new Employee("FirstName3", "LastName3", new Date(), Position.DEVELOPER, departmentDevelopment);
        Employee employee4 = new Employee("FirstName4", "LastName4", new Date(), Position.DEVELOPER, departmentDevelopment);
        departmentDevelopment.addEmployee(employee1);
        departmentDevelopment.addEmployee(employee2);
        departmentDevelopment.addEmployee(employee3);
        departmentDevelopment.addEmployee(employee4);

        Employee employee5 = new Employee("FirstName5", "LastName5", new Date(), Position.TEAM_LEAD, departmentFinance);
        Employee employee6 = new Employee("FirstName6", "LastName6", new Date(), Position.MANAGER, departmentFinance);
        Employee employee7 = new Employee("FirstName7", "LastName7", new Date(), Position.MANAGER, departmentFinance);
        Employee employee8 = new Employee("FirstName8", "LastName8", new Date(), Position.ANALYST, departmentFinance);
        departmentFinance.addEmployee(employee5);
        departmentFinance.addEmployee(employee6);
        departmentFinance.addEmployee(employee7);
        departmentFinance.addEmployee(employee8);


        Employee employee9 = new Employee("FirstName9", "LastName9", new Date(), Position.TEAM_LEAD, departmentDesign);
        Employee employee10 = new Employee("FirstName10", "LastName10", new Date(), Position.DESIGNER, departmentDesign);
        Employee employee11 = new Employee("FirstName11", "LastName11", new Date(), Position.DESIGNER, departmentDesign);
        Employee employee12 = new Employee("FirstName12", "LastName12", new Date(), Position.DESIGNER, departmentDesign);
        departmentDesign.addEmployee(employee9);
        departmentDesign.addEmployee(employee10);
        departmentDesign.addEmployee(employee11);
        departmentDesign.addEmployee(employee12);


        employee1.addProject(project1);
        employee2.addProject(project1);
        employee2.addProject(project2);
        employee2.addProject(project3);
        employee3.addProject(project1);
        employee3.addProject(project3);
        employee4.addProject(project2);
        employee4.addProject(project3);

        employee5.addProject(project2);
        employee6.addProject(project2);
        employee6.addProject(project3);
        employee7.addProject(project1);
        employee7.addProject(project2);
        employee8.addProject(project2);
        employee8.addProject(project3);

        employee9.addProject(project3);
        employee10.addProject(project3);
        employee10.addProject(project1);
        employee11.addProject(project2);
        employee11.addProject(project3);

        Firm firm = new Firm(new Date());
        firm.addDepartment(departmentDevelopment);
        firm.addDepartment(departmentFinance);
        firm.addDepartment(departmentDesign);
        firm.addCustomer(customer1);
        firm.addCustomer(customer2);
        firm.addCustomer(customer3);

        DepartmentDAO.add(departmentDevelopment);
        DepartmentDAO.add(departmentFinance);
        DepartmentDAO.add(departmentDesign);

        ProjectDAO.add(project1);
        ProjectDAO.add(project2);
        ProjectDAO.add(project3);

        EmployeeDAO.add(employee1);
        EmployeeDAO.add(employee2);
        EmployeeDAO.add(employee3);
        EmployeeDAO.add(employee4);
        EmployeeDAO.add(employee5);
        EmployeeDAO.add(employee6);
        EmployeeDAO.add(employee7);
        EmployeeDAO.add(employee8);
        EmployeeDAO.add(employee9);
        EmployeeDAO.add(employee10);
        EmployeeDAO.add(employee11);
        EmployeeDAO.add(employee12);

        System.out.println("Employees by project:" + project1.getName());
        System.out.println(Controller.employeesByProject(project1.getName()));

        System.out.println("Employees by project:" + project2.getName());
        System.out.println(Controller.employeesByProject(project2.getName()));

        System.out.println("Employees by project:" + project3.getName());
        System.out.println(Controller.employeesByProject(project3.getName()));

        System.out.println("Projects by employee:" + employee1);
        System.out.println(Controller.projectsByEmployee(employee1));

        System.out.println("Projects by employee:" + employee2);
        System.out.println(Controller.projectsByEmployee(employee2));

        System.out.println("Projects by employee:" + employee3);
        System.out.println(Controller.projectsByEmployee(employee3));

        System.out.println("Employees by department without project (Department:" + departmentDesign.getType() + ")");
        System.out.println(Controller.employeesByDepartmentWithoutProject(DepartmentType.DESIGN));

        System.out.println("Employees without project");
        System.out.println(Controller.employeesWithoutProject());

        System.out.println("Employees by team lead (Team Lead:" + employee1.getFirstName() + " " + employee1.getLastName() + ")");
        System.out.println(Controller.employeesByTeamLead(employee1));

        System.out.println("Employees by team lead (Team Lead:" + employee5.getFirstName() + " " + employee5.getLastName() + ")");
        System.out.println(Controller.employeesByTeamLead(employee5));

        System.out.println("Employees by team lead (Team Lead:" + employee9.getFirstName() + " " + employee9.getLastName() + ")");
        System.out.println(Controller.employeesByTeamLead(employee9));

        System.out.println("Team leads by employee (Employee:" + employee2.getFirstName() + " " + employee2.getLastName() + ")");
        System.out.println(Controller.teamLeadsByEmployee(employee2));

        System.out.println("Team leads by employee (Employee:" + employee3.getFirstName() + " " + employee3.getLastName() + ")");
        System.out.println(Controller.teamLeadsByEmployee(employee3));

        System.out.println("Employees by project employee (Employee:" + employee2.getFirstName() + " " + employee2.getLastName() + ")");
        System.out.println(Controller.employeesByProjectEmployee(employee2));

        System.out.println("Employees by project employee (Employee:" + employee7.getFirstName() + " " + employee7.getLastName() + ")");
        System.out.println(Controller.employeesByProjectEmployee(employee7));

        System.out.println("Projects by " + customer1);
        System.out.println(Controller.projectsByCustomer(customer1));

        System.out.println("Projects by " + customer2);
        System.out.println(Controller.projectsByCustomer(customer2));

        System.out.println("Projects by " + customer3);
        System.out.println(Controller.projectsByCustomer(customer3));

        System.out.println("Employees by customer projects (Customer: " + customer1.getName() + ")");
        System.out.println(Controller.employeesByCustomerProjects(customer1));

        System.out.println("Employees by customer projects (Customer: " + customer2.getName() + ")");
        System.out.println(Controller.employeesByCustomerProjects(customer2));

        System.out.println("Employees by customer projects (Customer: " + customer2.getName() + ")");
        System.out.println(Controller.employeesByCustomerProjects(customer2));
    }
}
