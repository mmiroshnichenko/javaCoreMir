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
        if (amount > user.getBank().getLimitOfFunding()) {
            return;
        }

        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount)
            || (amount > toUser.getBank().getLimitOfFunding())
            || (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())) {
            return;
        }

        withdraw(fromUser, amount);
        fund(toUser, amount);
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
    }


    private boolean checkWithdraw(User user, int amount) {
        return (amount + user.getBank().getCommission(amount)) <= user.getBank().getLimitOfWithdrawal()
               && (amount + user.getBank().getCommission(amount)) <= user.getBalance();
    }

}
