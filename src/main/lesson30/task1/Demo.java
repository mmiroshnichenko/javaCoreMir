package main.lesson30.task1;

public class Demo {
    public static void main(String[] args) throws Exception {
        Bank euBankEur = new EUBank(1301, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank euBankUsd = new EUBank(1302, "Sweden", Currency.USD, 100, 1400, 4, 444343434);

        Bank usBankUsd = new USBank(1303, "Morgan", Currency.USD, 120, 1600, 5, 844343434);
        Bank usBankEur = new USBank(1304, "Morgan", Currency.EUR, 120, 1600, 5, 844343434);

        Bank chinaBankUsd = new USBank(1305, "Mao", Currency.USD, 820, 400, 3, 544343434);
        Bank chinaBankEur = new USBank(1306, "Mao", Currency.USD, 820, 400, 3, 544343434);

        Bank[] allBanks = new Bank[]{euBankEur, euBankUsd, usBankEur, usBankUsd, chinaBankEur, chinaBankUsd};
        for (Bank bank : allBanks) {
            printBankData(bank);
        }



        User user1 = new User(2001, "Denis", 12200, 40, "GMD", 1500, euBankEur);
        User user2 = new User(2002, "Maxim", 18200, 60, "GMD", 1200, euBankEur);

        User user3 = new User(2003, "Pavel", 100, 20, "GMC", 1800, usBankUsd);
        User user4 = new User(2004, "Nik", 11200, 10, "GMC", 1700, usBankUsd);

        User user5 = new User(2005, "Lee", 100, 100, "SNB", 600, chinaBankUsd);
        User user6 = new User(2006, "Ma", 1000, 120, "SNB", 700, chinaBankEur);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();

        withdrawFromUser(bankSystem, user1, 100);
        Thread.sleep(2000);
        //свыше лимита
        withdrawFromUser(bankSystem, user1, 20000);
        Thread.sleep(2000);
        withdrawFromUser(bankSystem, user2, 200);
        Thread.sleep(2000);
        //свыше лимита
        withdrawFromUser(bankSystem, user2, 20000);
        Thread.sleep(2000);

        //свыше баланса
        withdrawFromUser(bankSystem, user3, 300);
        Thread.sleep(2000);
        withdrawFromUser(bankSystem, user4, 150);
        Thread.sleep(2000);
        withdrawFromUser(bankSystem, user5, 10);
        Thread.sleep(2000);
        withdrawFromUser(bankSystem, user6, 90);
        Thread.sleep(2000);

        fundToUser(bankSystem, user1, 100);
        Thread.sleep(2000);
        fundToUser(bankSystem, user1, 10000);
        Thread.sleep(2000);
        fundToUser(bankSystem, user2, 200);
        Thread.sleep(2000);
        fundToUser(bankSystem, user2, 2100000);
        Thread.sleep(2000);
        fundToUser(bankSystem, user3, 300);
        Thread.sleep(2000);
        fundToUser(bankSystem, user4, 150);
        Thread.sleep(2000);
        fundToUser(bankSystem, user5, 10);
        Thread.sleep(2000);
        fundToUser(bankSystem, user6, 90);
        Thread.sleep(2000);

        transfer(bankSystem, user1, user2, 20);
        Thread.sleep(2000);
        transfer(bankSystem, user2, user1, 40);
        Thread.sleep(2000);
        transfer(bankSystem, user3, user4, 30);
        Thread.sleep(2000);
        transfer(bankSystem, user4, user3, 10);
        Thread.sleep(2000);
        transfer(bankSystem, user5, user6, 25);
        Thread.sleep(2000);
        transfer(bankSystem, user6, user5, 10);
        Thread.sleep(2000);

        // разные валюты
        transfer(bankSystem, user1, user3, 10);


        User[] users = {user1, user2, user3, user4, user5, user6};
        paySalaryForUsers(bankSystem, users);

        for (Transaction transaction : bankSystem.getTransactions()) {
            System.out.println(transaction);
        }

    }

    public static void printBankData(Bank bank) {
        System.out.println();
        System.out.println("Name of Country: " + bank.getBankCountry());
        System.out.println("Currency: " + bank.getCurrency());
        System.out.println("LimitOfWithdrawal: " + bank.getLimitOfWithdrawal());
        System.out.println("LimitOfFunding: " + bank.getLimitOfFunding());
        System.out.println("MonthlyRate: " + bank.getMonthlyRate());
        System.out.println("Commission for 100: " + bank.getCommission(100));
        System.out.println("Commission for 1000: " + bank.getCommission(10000));
    }

    public static void withdrawFromUser(BankSystem bankSystem, User user, int amount) {
        System.out.println();
        System.out.println(user.toString());
        bankSystem.withdraw(user, amount);
        System.out.println(user.getBalance());
    }

    public static void fundToUser(BankSystem bankSystem, User user, int amount) {
        System.out.println();
        System.out.println(user.toString());
        bankSystem.fund(user, amount);
        System.out.println(user.getBalance());
    }

    public static void transfer(BankSystem bankSystem, User fromUser, User toUser, int amount) {
        System.out.println();
        System.out.println(fromUser.toString());
        System.out.println(toUser.toString());
        bankSystem.transferMoney(fromUser, toUser, amount);
        System.out.println(fromUser.getBalance());
        System.out.println(toUser.getBalance());
    }

    public static void paySalaryForUsers(BankSystem bankSystem, User[] users) {
        System.out.println();
        for (User user : users) {
            System.out.println(user.toString());
            bankSystem.paySalary(user);
            System.out.println(user.getBalance());
        }
    }
}
