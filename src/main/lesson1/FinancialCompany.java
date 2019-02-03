package main.lesson1;

import main.lesson9.company.Company;

public class FinancialCompany extends Company {
    public static void main(String[] args) {

    }

    public FinancialCompany(String name, String countryFounded) {
        super(name, countryFounded);
    }

    void demonstrateProtectedModifier() {
        System.out.println(this.code);
    }
}
