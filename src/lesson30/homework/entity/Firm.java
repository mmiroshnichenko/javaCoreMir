package lesson30.homework.entity;

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
}
