package lesson9.company;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("testt", "Ukraine");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());
        company.setCountryFounded("UK");
        System.out.println(company.getCountryFounded());
        company.setCountryFounded("");
        System.out.println(company.getCountryFounded());
        company.setCountryFounded(null);
        System.out.println(company.getCountryFounded());

        Employee employee = new Employee("Pavel", company, 1200);
        System.out.println(employee);

    }
}
