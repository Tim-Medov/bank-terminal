
package enterprise.client;

public class Individual implements Account {

    protected AccountType accountType;
    protected int accountNumber;
    protected double amount;

    public Individual(AccountType accountType, int accountNumber, double amount) {
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

        } else {

            amount = amount + amountToPut;

            System.out.println("The amount " + amountToPut + " has been deposited into your account");
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
