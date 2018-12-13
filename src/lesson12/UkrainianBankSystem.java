package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount)) {
            return;
        }

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFundingLimit(user, amount)) {
            return;
        }

        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount)) {
            return;
        }

        if (!checkFundingLimit(toUser, amount)) {
            return;
        }

        if (!checkTransferCurrency(fromUser, toUser)) {
            return;
        }

        withdraw(fromUser, amount);
        fund(toUser, amount);
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
    }

    private boolean checkTransferCurrency(User fromUser, User toUser) {
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            printTransferErrorMsg(fromUser, toUser);

            return false;
        }

        return true;
    }

    private void printTransferErrorMsg(User fromUser, User toUser) {
        System.err.println("Can't transfer currency " + fromUser.getBank().getCurrency() + " to " + toUser.getBank().getCurrency());
    }

    private boolean checkFundingLimit(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg(amount, user);

            return false;
        }

        return true;
    }

    private void printFundingErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + " to user " + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if ((amount + user.getBank().getCommission(amount)) > limit) {
            printWithdrawalErrorMsg(amount, user);

            return false;
        }

        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }
}
