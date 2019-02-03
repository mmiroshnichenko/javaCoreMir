package main.lesson30.homework.dao;

import main.lesson30.homework.entity.Customer;
import main.lesson30.homework.entity.Employee;
import main.lesson30.homework.entity.Project;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {
    private static Set<Project> projects = new HashSet<>();

    public static Project add(Project project) throws Exception {
        if (projects.add(project)) {
            return project;
        }

        throw new Exception("Error: " + project + " already exist in base");
    }

    public static Set<Project> getProjects() {
        return projects;
    }

    public static Set<Project> projectsByEmployee(Employee employee) {
        return employee.getProjects();
    }

    public static Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> projectsSet = new HashSet<>();

        for (Project project : projects) {
            if (project.getCustomer().equals(customer)) {
                projectsSet.add(project);
            }
        }

        return projectsSet;
    }
}
