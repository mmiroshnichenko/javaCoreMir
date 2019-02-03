package main.lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount)) {
            return;
        }

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            user.setBalance(user.getBalance() + amount);
            createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsdc");
        }
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount)
            || (amount > toUser.getBank().getLimitOfFunding())
            || (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())) {
            printTransferErrorMsg(amount, fromUser, toUser);
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdsdc");
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc");
    }


    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawalLimits(user, amount, user.getBank().getLimitOfWithdrawal())
                && checkWithdrawalLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawalLimits(User user, int amount, double limit) {
        if (amount + amount * user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }

        return true;
    }

    private void printTransferErrorMsg(int amount, User fromUser, User toUser) {
        System.err.println("Can't transfer money " + amount + " from user " + fromUser.toString() + " to user " + toUser.toString());
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);

        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

}
