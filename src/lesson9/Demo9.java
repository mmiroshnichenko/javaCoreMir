package lesson9;

import lesson9.utils.Checker;

public class Demo9 {
    public static void main(String[] args) {
        Company company = new Company("testt", "Ukraine");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
        //System.out.println(checker.companyNamesValidatedCount);
        //company.code
    }
}
