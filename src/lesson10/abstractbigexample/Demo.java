package lesson10.abstractbigexample;

public class Demo {
    public static void main(String[] args) {
        Company company1 = new Company("IBM");
        Company company2 = new Company("Oracle");
        Company company3 = new Company("GMC");
        Company[] companies = {company1, company2, company3};
        printCompanies(companies);

        String positionDev = "Dev";
        String positionQA = "QA";
        String positionManager = "Manager";
        String[] positions = {positionDev, positionQA, positionManager, null, null, null};

        String framework1 = "Framework1";
        String framework2 = "Framework2";
        String framework3 = "Framework3";
        String[] frameworks = {framework1, framework2, framework3};

        DeveloperEmployee developerEmployee = new DeveloperEmployee("Pavel", 25, 5, positionDev, 1500, companies, positions, frameworks);
        ManagerEmployee managerEmployee = new ManagerEmployee("Denis", 30, 10, positionManager, 2500, companies, positions);

        System.out.println(developerEmployee);
        System.out.println(managerEmployee);

        System.out.println(developerEmployee.getBankAccount());
        System.out.println(managerEmployee.getBankAccount());

        BankAccount bankAccountDeveloper = new BankAccount(developerEmployee, 2000);
        BankAccount bankAccountManager = new BankAccount(managerEmployee, 3000);

        developerEmployee.setBankAccount(bankAccountDeveloper);
        System.out.println(developerEmployee);
        developerEmployee.setBankAccount(bankAccountManager);
        System.out.println(developerEmployee);
        managerEmployee.setBankAccount(bankAccountManager);
        System.out.println(developerEmployee.getBankAccount());
        System.out.println(managerEmployee.getBankAccount());

        developerEmployee.changePosition("Java developer");
        System.out.println(developerEmployee);
        developerEmployee.changePosition("developer C++");
        System.out.println(developerEmployee);
        developerEmployee.changePosition(null);

        managerEmployee.changePosition("Project manager");
        System.out.println(managerEmployee);

        System.out.println(developerEmployee.getSalaryPerMonth());
        System.out.println(managerEmployee.getSalaryPerMonth());

        developerEmployee.paySalary();
        managerEmployee.paySalary();

        if (developerEmployee.getBalance() == 4500) {
            System.out.println("Developer received correct salary");
        } else {
            System.out.println("Wrong logic calculation salary for developer");
        }
        System.out.println(developerEmployee.getBalance());

        if (managerEmployee.getBalance() == 6875) {
            System.out.println("Manager received correct salary");
        } else {
            System.out.println("Wrong logic calculation salary for manager");
        }
        System.out.println(managerEmployee.getBalance());
    }

    private static void printCompanies(Company[] companies) {
        for (Company company : companies) {
            System.out.println(company);
        }
    }
}
