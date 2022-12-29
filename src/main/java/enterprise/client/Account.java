
package enterprise.client;

public interface Account {

    AccountType getAccountType();
    int getAccountNumber();
    double getAmount();
    void setAmount(double amount);
    void putFunds(double amountToPut);
    void takeFunds(double amountToTake);
    String accountInfo();
}
