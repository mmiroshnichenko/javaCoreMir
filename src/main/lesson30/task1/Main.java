package main.lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank usBank = new USBank(1223, "Morgan", Currency.USD, 120, 1600, 5, 844343434);
        Bank chinaBank = new USBank(1224, "Mao", Currency.USD, 820, 400, 3, 544343434);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user2 = new User(1002, "Maxim", 18200, 60, "GMD", 1200, euBank);

        User user3 = new User(1003, "Pavel", 16200, 20, "GMC", 1800, usBank);
        User user4 = new User(1004, "Nik", 11200, 10, "GMC", 1700, usBank);

        User user5 = new User(1005, "Lee", 100, 100, "SNB", 600, chinaBank);
        User user6 = new User(1006, "Ma", 1000, 120, "SNB", 700, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        withdrawFromUser(bankSystem, user1, 100);
        withdrawFromUser(bankSystem, user2, 200);
        withdrawFromUser(bankSystem, user3, 300);
        withdrawFromUser(bankSystem, user4, 150);
        withdrawFromUser(bankSystem, user5, 10);
        withdrawFromUser(bankSystem, user6, 90);

        fundToUser(bankSystem, user1, 100);
        fundToUser(bankSystem, user2, 200);
        fundToUser(bankSystem, user3, 300);
        fundToUser(bankSystem, user4, 150);
        fundToUser(bankSystem, user5, 10);
        fundToUser(bankSystem, user6, 90);

        transfer(bankSystem, user1, user2, 20);
        transfer(bankSystem, user2, user1, 40);
        transfer(bankSystem, user3, user4, 30);
        transfer(bankSystem, user4, user3, 10);
        transfer(bankSystem, user5, user6, 25);
        transfer(bankSystem, user6, user5, 10);

        User[] users = {user1, user2, user3, user4, user5, user6};

    }

    public static void withdrawFromUser(BankSystem bankSystem, User user, int amount) {
        printUserInfo(user);
        bankSystem.withdraw(user, amount);
        printUserBalance(user);
    }

    public static void fundToUser(BankSystem bankSystem, User user, int amount) {
        printUserInfo(user);
        bankSystem.fund(user, amount);
        printUserBalance(user);
    }

    public static void transfer(BankSystem bankSystem, User fromUser, User toUser, int amount) {
        printUserInfo(fromUser);
        printUserInfo(toUser);
        bankSystem.transferMoney(fromUser, toUser, amount);
        printUserBalance(fromUser);
        printUserBalance(toUser);
    }

    public static void paySalaryForUsers(BankSystem bankSystem, User[] users) {
        for (User user : users) {
            printUserInfo(user);
            bankSystem.paySalary(user);
            printUserBalance(user);
        }
    }

    private static void printUserInfo(User user) {
        System.out.println(user.toString());
    }

    private static void printUserBalance(User user) {
        System.out.println(user.getBalance());
    }
}
