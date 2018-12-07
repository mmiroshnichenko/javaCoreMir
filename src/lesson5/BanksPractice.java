package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, 99, 12000, -54, 0};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));

        depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));

        int[] numbers = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 0};
        System.out.println(Arrays.toString(numbers));
        System.out.println(uniqueCount(numbers));
    }

    public static int uniqueCount(int[] array) {
        int[] tmp = new int[0];

        int index = 0;
        for (int el : array) {
            if (!contains(tmp, el)) {
                tmp = addToArray(tmp, el);
                index++;
            }
        }

        tmp = null;

        return index;
    }

    public static boolean contains(int[] array, int element) {
        for (int el : array) {
            if (el == element) {
                return true;
            }
        }

        return false;
    }

    public static int[] addToArray(int[] array, int newEl) {
        int[] tmp = Arrays.copyOf(array, array.length + 1);
        tmp[array.length] = newEl;

        return tmp;
    }


    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        if (balances[findClientIndexByName(clients, client)] >= amount) {
            balances[findClientIndexByName(clients, client)] -= amount;

            return balances[findClientIndexByName(clients, client)];
        }

        return -1;
    }

    public static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        //String [] results = new String[clients.length];

        int count = 0;
        for (int balance : balances) {
            if (balance >= n) {
                count++;
            }
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

    public static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        //String [] results = new String[clients.length];

        int count = 0;
        for (int balance : balances) {
            if (balance < 0) {
                count++;
            }
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

    public static void depositMoney(String[] clients, int[] balances, String client, int money) {
        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;

        for (String cl : clients) {
            if(cl == client) {
                break;
            }

            clientIndex++;
        }

        return clientIndex;
    }

    public static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }
}
