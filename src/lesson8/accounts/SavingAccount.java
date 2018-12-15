package lesson8.accounts;

public class SavingAccount extends Account{
    int savingPerMonth;

    public SavingAccount(String bankName, String ownerName, int moneyAmount, int savingPerMonth) {
        super(bankName, ownerName, moneyAmount);
        this.savingPerMonth = savingPerMonth;
    }

    @Override
    void changeOwnerName(String newOwnerName) {
        if (newOwnerName != null && (newOwnerName.equals("Jack") || newOwnerName.equals("Ann"))) {
            ownerName = newOwnerName;
        } else {
            System.out.println("Sorry, you cant't change owner name of this saving account");
        }
    }
}
