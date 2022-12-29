
package enterprise.client;

public class Entrepreneur implements Account {

    private AccountType accountType;
    private int accountNumber;
    private double amount;

    public Entrepreneur(AccountType accountType, int accountNumber, double amount) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void putFunds(double amountToPut) {

        if (amountToPut <= 0) {

            System.out.println("Invalid deposit amount entered");

        } else if (amountToPut < 1000) {

            double interestOnePercent = amountToPut / 100;

            double withheldAmount = amountToPut - interestOnePercent;

            amount = amount + withheldAmount;

            System.out.println("The amount " + withheldAmount +
                    " after deducting interest is deposited into your account");

        } else if (amountToPut >= 1000) {

            double interestHalfPercent = amountToPut / 200;

            double withheldAmount = amountToPut - interestHalfPercent;

            amount = amount + withheldAmount;

            System.out.println("The amount " + withheldAmount +
                    " after deducting interest is deposited into your account");
        }
    }

    @Override
    public void takeFunds(double amountToTake) {

        if (amountToTake > amount) {

            System.out.println("The amount entered exceeded the balance on the account");

        } else {

            amount = amount - amountToTake;

            System.out.println("The amount " + amountToTake + " has been withdrawn from your account");
        }
    }

    @Override
    public String accountInfo() {
        return "Account Number: " + accountNumber + "    Type: " + accountType + "    Amount: " + amount + " $";
    }
}
