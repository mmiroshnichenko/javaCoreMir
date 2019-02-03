package main.lesson9.utils;

public class Demo {
    public static void main(String[] args) {
        Checker checker = new Checker();
        System.out.println(checker.companyNamesValidatedCount);

        check(checker, "Dent");
        check(checker, "Google");
        check(checker, "Amazon");
        check(checker, "Amadeus");
        check(checker, "Luxsoft");
        check(checker, "Epam");
        check(checker, "FRM");
        check(checker, "GMC");
        check(checker, "Yandex");
        check(checker, "Test");
        check(checker, "Novus");
        check(checker, "FNV");


    }

    public static void check(Checker checker, String name) {
        if (checker.checkCompanyName(name)) {
            System.out.println("Company name '" + name + "' is valid");
        } else {
            System.out.println("Wrong company name '" + name + "' or validated count is more than 10");
        }
        System.out.println(checker.companyNamesValidatedCount);
    }
}
