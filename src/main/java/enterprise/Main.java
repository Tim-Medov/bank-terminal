
package enterprise;

import enterprise.client.AccountType;
import enterprise.client.Client;
import enterprise.bank.Bank;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner input = new Scanner(System.in);

        while (true) {

            String line = "";

            System.out.println("\n--THE BANK APPLICATION CONSOLE--\n" +
                    "Command - \"EXIT\" exit from the application\n" +
                    "Command - \"REG\" register as a new client of the Bank\n" +
                    "Command - \"LOGIN\" login as a client of the Bank\n" +
                    "Command - \"MANAGER\" authorize as the Bank manager\n");

            line = input.nextLine();

            // stop the application by command "exit"
            if (line.equalsIgnoreCase("Exit")) {
                break;
            }

            // register a new bank client by command "reg"
            if (line.equalsIgnoreCase("Reg")) {

                String username = "";
                String password = "";

                System.out.println("Enter username: (username must contain only latin letters, digits, dashes and dots)");

                username = input.nextLine();

                if (username.isBlank()) {

                    System.out.println("Username can't be empty");

                } else if (!username.equals(bank.textValidator(username))) {

                    System.out.println("You entered invalid characters");

                } else {

                    System.out.println("Enter password: (password must contain only latin letters, digits, dashes and dots)");

                    password = input.nextLine();

                    if (password.isBlank()) {

                        System.out.println("Username can't be empty");

                    } else if (!password.equals(bank.textValidator(password))) {

                        System.out.println("You entered invalid characters");

                    } else {

                        if (bank.getClients().containsKey(username)) {

                            System.out.println("Such a client already exists");

                        } else {

                            bank.addClient(new Client(username, password));
                        }
                    }
                }
            }

            // login into bank as a client by command "login"
            if (line.equalsIgnoreCase("Login")) {

                String username = "";
                String password = "";

                System.out.println("Enter username:");

                username = input.nextLine();

                if (!bank.getClients().containsKey(username)) {

                    System.out.println("Such a user does not exist");

                } else {

                    System.out.println("Enter password:");

                    password = input.nextLine();

                    if (!password.equals(bank.getClients().get(username).getPassword())) {

                        System.out.println("You entered an invalid password");

                    } else {

                        // nested loop to manage your bank accounts
                        while (true) {

                            System.out.println("\n--COMMANDS TO MANAGE ACCOUNTS--\n" +
                                    "Command - \"LOGOUT\" logout and return to reg/login step\n" +
                                    "Command - \"INFO\" get account information\n" +
                                    "Command - \"OPEN\" open a new account\n" +
                                    "Command - \"PUT\" put funds to account\n" +
                                    "Command - \"TAKE\" take funds from account\n" +
                                    "Command - \"TRANSFER\" transfer funds between your accounts\n" +
                                    "Command - \"DELETE\" delete account\n" +
                                    "Command - \"TOTAL\" Get the total amount of funds from all accounts\n"
                            );

                            line = input.nextLine();

                            // logout and return to reg/login step by command "logout"
                            if (line.equalsIgnoreCase("Logout")) {
                                break;
                            }

                            // get your account information by command "info"
                            if (line.equalsIgnoreCase("Info")) {

                                bank.getClient(username).getClientInfo();
                            }

                            // open new account by command "open"
                            if (line.equalsIgnoreCase("Open")) {

                                String accountType = "";
                                String amount = "";

                                System.out.println("Select and enter an account type: (ENTREPRENEUR, INDIVIDUAL, LEGAL)");

                                accountType = input.nextLine();

                                if (accountType.equalsIgnoreCase("Entrepreneur")) {

                                    System.out.println("Enter an amount:");

                                    amount = input.nextLine();

                                    if (!amount.equals(bank.digitsValidator(amount)) || amount.isBlank()) {

                                        System.out.println("Invalid amount");

                                    } else {

                                        bank.getClient(username).addAccount(AccountType.ENTREPRENEUR, Double.parseDouble(amount));
                                    }

                                } else if (accountType.equalsIgnoreCase("Individual")) {

                                    System.out.println("Enter an amount:");

                                    amount = input.nextLine();

                                    if (!amount.equals(bank.digitsValidator(amount)) || amount.isBlank()) {

                                        System.out.println("Invalid amount");

                                    } else {

                                        bank.getClient(username).addAccount(AccountType.INDIVIDUAL, Double.parseDouble(amount));
                                    }

                                } else if (accountType.equalsIgnoreCase("Legal")) {

                                    System.out.println("Enter an amount:");

                                    amount = input.nextLine();

                                    if (!amount.equals(bank.digitsValidator(amount)) || amount.isBlank()) {

                                        System.out.println("Invalid amount");

                                    } else {

                                        bank.getClient(username).addAccount(AccountType.LEGAL, Double.parseDouble(amount));
                                    }
                                }
                            }

                            // put funds to account by command "put"
                            if (line.equalsIgnoreCase("Put")) {

                                String accountNumber = "";
                                String amount = "";

                                System.out.println("Enter the account number:");

                                accountNumber = input.nextLine();

                                if (!accountNumber.equals(bank.digitsValidator(accountNumber)) || accountNumber.isBlank()) {

                                    System.out.println("Wrong account number");

                                } else {

                                    System.out.println("Enter an amount:");

                                    amount = input.nextLine();

                                    if (!amount.equals(bank.digitsValidator(amount)) || amount.isBlank()) {

                                        System.out.println("Invalid amount");

                                    } else {

                                        bank.getClient(username).putFunds(Integer.parseInt(accountNumber), Double.parseDouble(amount));
                                    }
                                }
                            }

                            // take funds from account by command "take"
                            if (line.equalsIgnoreCase("Take")) {

                                String accountNumber = "";
                                String amount = "";

                                System.out.println("Enter the account number:");

                                accountNumber = input.nextLine();

                                if (!accountNumber.equals(bank.digitsValidator(accountNumber)) || accountNumber.isBlank()) {

                                    System.out.println("Wrong account number");

                                } else {

                                    System.out.println("Enter an amount:");

                                    amount = input.nextLine();

                                    if (!amount.equals(bank.digitsValidator(amount)) || amount.isBlank()) {

                                        System.out.println("Invalid amount");

                                    } else {

                                        bank.getClient(username).takeFunds(Integer.parseInt(accountNumber), Double.parseDouble(amount));
                                    }
                                }
                            }

                            // transfer funds between accounts by command "transfer"
                            if (line.equalsIgnoreCase("Transfer")) {

                                String fromAccount = "";
                                String toAccount = "";
                                String amountToTransfer = "";

                                System.out.println("Enter the account number FROM transfer funds:");

                                fromAccount = input.nextLine();

                                if (!fromAccount.equals(bank.digitsValidator(fromAccount)) || fromAccount.isBlank()) {

                                    System.out.println("Wrong account number");

                                } else {

                                    System.out.println("Enter the account number WHERE to transfer funds:");

                                    toAccount = input.nextLine();

                                    if (!toAccount.equals(bank.digitsValidator(toAccount)) || toAccount.isBlank()) {

                                        System.out.println("Wrong account number");

                                    } else {

                                        System.out.println("Enter an amount to transfer:");

                                        amountToTransfer = input.nextLine();

                                        if (!amountToTransfer.equals(bank.digitsValidator(amountToTransfer)) || amountToTransfer.isBlank()) {

                                            System.out.println("Invalid amount");

                                        } else {

                                            bank.getClient(username).transferFunds(Integer.parseInt(fromAccount), Integer.parseInt(toAccount), Double.parseDouble(amountToTransfer));
                                        }
                                    }
                                }
                            }

                            // delete account by command "delete"
                            if (line.equalsIgnoreCase("Delete")) {

                                String accountNumber = "";

                                System.out.println("Enter the account number to delete:");

                                accountNumber = input.nextLine();

                                if (!accountNumber.equals(bank.digitsValidator(accountNumber)) || accountNumber.isBlank()) {

                                    System.out.println("Wrong account number");

                                } else {

                                    bank.getClient(username).deleteAccount(Integer.parseInt(accountNumber));
                                }
                            }

                            // get the total amount of funds from all accounts by command "total"
                            if (line.equalsIgnoreCase("total")) {

                                double totalFunds = bank.getClient(username).getTotalClientFunds();

                                System.out.println("Total funds from all accounts: " + totalFunds);
                            }
                        }
                    }
                }
            }

            // authorize as the bank manager by command "manager"
            if (line.equalsIgnoreCase("Manager")) {

                String managerName = "";
                String managerPassword = "";

                System.out.println("Enter Manager Name:");

                managerName = input.nextLine();

                if (!managerName.equals(bank.getManagerName())) {

                    System.out.println("Such a Bank manager does not exist");

                } else {

                    System.out.println("Enter Manager Password:");

                    managerPassword = input.nextLine();

                    if (!managerPassword.equals(bank.getManagerPassword())) {

                        System.out.println("You entered an invalid Manager password...\n");

                    } else {

                        // nested loop for bank manager operations
                        while (true) {

                            String clientName = "";
                            String clientPassword = "";

                            System.out.println("\n--BANK MANAGER COMMANDS--\n" +
                                    "Command - \"LOGOUT\" logout and return to reg/login step\n" +
                                    "Command - \"CLIENTS\" show all Bank clients\n" +
                                    "Command - \"SUM\" show funds sum of all Bank clients\n" +
                                    "Command - \"ADD\" add a new Bank client\n" +
                                    "Command - \"DELETE\" delete the Bank client\n"
                            );

                            line = input.nextLine();

                            // logout and return to reg/login step by command "logout"
                            if (line.equalsIgnoreCase("Logout")) {
                                break;
                            }

                            // show all bank clients by command "clients"
                            if (line.equalsIgnoreCase("Clients")) {

                                bank.showAllClients();
                            }

                            // get funds sum of all bank clients by command "sum"
                            if (line.equalsIgnoreCase("Sum")) {

                                bank.getTotalFundsSum();
                            }

                            // add a new bank client by command "add"
                            if (line.equalsIgnoreCase("Add")) {

                                System.out.println("Enter client name: (client name must contain only latin letters, digits, dashes and dots)");

                                clientName = input.nextLine();

                                if (clientName.isBlank()) {

                                    System.out.println("Client name can't be empty");

                                } else if (!clientName.equals(bank.textValidator(clientName))) {

                                    System.out.println("You entered invalid characters");

                                } else if (bank.getClients().containsKey(clientName)) {

                                    System.out.println("Such a client already exists");

                                } else {

                                    System.out.println("Enter client password: (client password must contain only latin letters, digits, dashes and dots)");

                                    clientPassword = input.nextLine();

                                    if (clientPassword.isBlank()) {

                                        System.out.println("Client password can't be empty");

                                    } else if (!clientPassword.equals(bank.textValidator(clientPassword))) {

                                        System.out.println("You entered invalid characters");

                                    } else {

                                        bank.addClient(new Client(clientName, clientPassword));
                                    }
                                }
                            }

                            // delete the bank client by command "delete"
                            if (line.equalsIgnoreCase("Delete")) {

                                System.out.println("Enter client name to delete:");

                                clientName = input.nextLine();

                                if (!bank.getClients().containsKey(clientName)) {

                                    System.out.println("Such a client doesn't exists");

                                } else {

                                    bank.deleteClient(bank.getClient(clientName));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
