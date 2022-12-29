
package enterprise.client;

import enterprise.statics.Generator;
import java.util.Map;
import java.util.TreeMap;

public class Client {

    private String username;
    private String password;
    private Map<Integer, Account> accounts;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new TreeMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccount(AccountType TYPE, double amount) {

        if (TYPE.equals(AccountType.ENTREPRENEUR)) {

            Entrepreneur entrepreneur =
                    new Entrepreneur(AccountType.ENTREPRENEUR, Generator.generateAccountNumber(), amount);

            if (accounts.containsKey(entrepreneur.getAccountNumber())) {
                System.out.println("Such account number already exists");
            } else {
                accounts.put(entrepreneur.getAccountNumber(), entrepreneur);
                System.out.println("Account ENTREPRENEUR successfully added");
            }

        } else if (TYPE.equals(AccountType.INDIVIDUAL)) {

            Individual individual =
                    new Individual(AccountType.INDIVIDUAL, Generator.generateAccountNumber(), amount);

            if (accounts.containsKey(individual.getAccountNumber())) {
                System.out.println("Such account number already exists");
            } else {
                accounts.put(individual.getAccountNumber(), individual);
                System.out.println("Account INDIVIDUAL successfully added");
            }

        } else if (TYPE.equals(AccountType.LEGAL)) {

            Legal legal =
                    new Legal(AccountType.LEGAL, Generator.generateAccountNumber(), amount);

            if (accounts.containsKey(legal.getAccountNumber())) {
                System.out.println("Such account number already exists");
            } else {
                accounts.put(legal.getAccountNumber(), legal);
                System.out.println("Account LEGAL successfully added");
            }
        }
    }

    public void deleteAccount(int accountNumber) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist");
        } else if (accounts.get(accountNumber).getAmount() > 10) {
            System.out.println("There are funds on your account exceeding 10$, " +
                    "to delete an account, the funds on the account must be from 0 to 10$. " +
                    "Please empty your account before deleting it.");
        } else if (accounts.get(accountNumber).getAmount() < 0) {
            System.out.println("You have a debt on your account, pay off the debt before deleting account");
        } else {
            accounts.remove(accountNumber);
            System.out.println("Account number " + accountNumber + " has been successfully deleted");
        }
    }

    public void putFunds(int accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist");
        } else {
            accounts.get(accountNumber).putFunds(amount);
        }
    }

    public void takeFunds(int accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist");
        } else {
            accounts.get(accountNumber).takeFunds(amount);
        }
    }

    public void transferFunds(int fromAccount, int toAccount, double amountToTransfer) {

        if (!accounts.containsKey(fromAccount) || !accounts.containsKey(toAccount)) {

            System.out.println("Invalid account(s) number");

        } else if (amountToTransfer > accounts.get(fromAccount).getAmount()) {

            System.out.println("The amount entered exceeded the balance on the account");

        } else {

            double restFromAccountAmount = accounts.get(fromAccount).getAmount() - amountToTransfer;

            accounts.get(fromAccount).setAmount(restFromAccountAmount);

            double totalToAccountAmount = accounts.get(toAccount).getAmount() + amountToTransfer;

            accounts.get(toAccount).setAmount(totalToAccountAmount);

            System.out.println("The amount " + amountToTransfer + " has been transfer from "
                    + fromAccount + " account to " + toAccount + " account");
        }
    }

    public double getTotalClientFunds() {

        double totalFunds = 0;

        for (Map.Entry<Integer, Account> account : accounts.entrySet()) {
            totalFunds = totalFunds + account.getValue().getAmount();
        }

        return totalFunds;
    }

    public void getClientInfo() {

        System.out.println("You have " + accounts.size() + " account(s) in our Bank:");

        accounts.forEach((key, value) -> System.out.println(value.accountInfo()));
    }
}
