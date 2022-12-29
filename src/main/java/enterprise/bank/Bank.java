
package enterprise.bank;

import enterprise.client.Client;
import java.util.*;

public class Bank {

    private String managerName;
    private String managerPassword;
    private Map<String, Client> clients;

    public Bank() {
        this.clients = new HashMap<>();
        this.managerName = "Robert";
        this.managerPassword = "rob123";
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Client getClient(String username) {

        if (!clients.containsKey(username)) {

            System.out.println("Client " + username + " does not exist");

        } else {

            return clients.get(username);

        }

        return null;
    }

    public void addClient(Client client) {

        if (clients.containsKey(client.getUsername())) {
            System.out.println("Such a client already exists");
        } else {
            clients.put(client.getUsername(), client);
            System.out.println("Client " + client.getUsername() + " successfully added to the Bank");
        }
    }

    public void deleteClient(Client client) {

        if (!clients.containsKey(client.getUsername())) {
            System.out.println("Such a client does not exist");
        } else {
            clients.remove(client.getUsername());
            System.out.println("The client " + client.getUsername() + " has been successfully removed from the database");
        }
    }

    public void showAllClients() {

        if (clients.isEmpty()) {
            System.out.println("Bank doesn't have any clients");
        } else {
            clients.forEach((key, value) -> System.out.println("Client: " + value.getUsername()));
        }
    }

    public void getTotalFundsSum() {

        double totalSum = 0;

        for (Map.Entry<String, Client> client : clients.entrySet()) {
            totalSum = totalSum + client.getValue().getTotalClientFunds();
        }

        System.out.println("Total funds amount in the Bank: " + totalSum);
    }

    public String textValidator(String text) {

        String validText = "";
        String regex = "[-_A-Za-z0-9.\\s]+";

        if (text.matches(regex) &&
                !text.equalsIgnoreCase("Exit") &&
                !text.equalsIgnoreCase("Reg") &&
                !text.equalsIgnoreCase("Login")) {

            validText = text;
        }

        return validText;
    }

    public String digitsValidator(String digits) {

        String validDigits = "";
        String regex = "[0-9.]+";

        if (digits.matches(regex)) {
            validDigits = digits;
        }

        return validDigits;
    }
}
