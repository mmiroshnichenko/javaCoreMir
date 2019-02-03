package main.lesson30.homework.entity;

import java.util.*;

public class Firm {
    private Date dateFounded;
    private Set<Department> departments = new HashSet<>();
    private Set<Customer> customers = new TreeSet<>();

    public Firm(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Department addDepartment(Department department) throws Exception {
        if (departments.add(department)) {
            return department;
        }

        throw new Exception("Error: " + department + " already exist in " + this.toString());
    }

    public Customer addCustomer(Customer customer) throws Exception {
        if (customers.add(customer)) {
            return customer;
        }

        throw new Exception("Error: " + customer + " already serviced in " + this.toString());
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                '}';
    }
}
