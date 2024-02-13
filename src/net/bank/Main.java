package net.bank;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String clientID;
        String accountNo;
        String name;
        String middleName;
        String surname;
        Person client;
        double amount;
        List<checkingAccount> accountList;
        int age;
        boolean loopSwitch = true;

        Bank bank1 = new Bank("BenBank");
        Scanner inputOperation = new Scanner(System.in);
        Scanner inputValues = new Scanner(System.in).useLocale(Locale.US);
        inputValues.useDelimiter("[,|\n]");

        while (loopSwitch){

            System.out.println("Welcome, teller, to " + bank1.getBankName());
            System.out.println("Please, select operation:");
            System.out.println("1. Create a new client");
            System.out.println("2. List all clients");
            System.out.println("3. Create an account for a client");
            System.out.println("4. List all accounts of a client");
            System.out.println("5. Decrease client's balance");
            System.out.println("6. Increase client's balance");
            System.out.println("7. Terminate program");

            int operation = inputOperation.nextInt();

            switch(operation){
                case 1:
                    System.out.println("Please provide the following data separated by commas (,) - name, middle name, surname, age");
                    name = inputValues.next();
                    middleName = inputValues.next();
                    surname = inputValues.next();
                    String ageString = inputValues.next();
                    age=Integer.parseInt(ageString);
                    bank1.createClient(name,middleName,surname,age);
                    break;
                case 2:
                    List<Person> allClients = bank1.getAllClients();
                    for (Person clientItem : allClients){
                        System.out.println("Client: " + clientItem.getFullName() + ". Identified by CID: " + clientItem.getClientID());
                    }
                    break;
                case 3:
                    System.out.println("Please provide the following data separated by commas (,) - clientID, initial deposit amount");
                    clientID = inputValues.next();
                    amount = inputValues.nextDouble();
                    client = bank1.getClientByID(clientID);
                    bank1.openAccount(client,amount);
                    break;
                case 4:
                    System.out.println("Please provide Client ID: ");
                    client = bank1.getClientByID(inputValues.next());
                    accountList = bank1.getClientAccounts(client);
                    System.out.println("Client " + client.getFullName() + ". Has following accounts: ");
                    for(checkingAccount accountItem : accountList){
                        accountItem.printAccountFullDetails();
                    }
                    break;
                case 5:
                    System.out.println("Please provide the following data separated by commas (,) - clientID, account number, withdraw amount");
                    clientID = inputValues.next();
                    accountNo = inputValues.next();
                    amount = inputValues.nextDouble();
                    bank1.withdrawMoney(clientID,accountNo,amount);
                    break;
                case 6:
                    System.out.println("Please provide the following data separated by commas (,) - clientID, account number, deposit amount");
                    clientID = inputValues.next();
                    accountNo = inputValues.next();
                    amount = inputValues.nextDouble();
                    bank1.depositMoney(clientID,accountNo,amount);
                    break;
                case 7:
                    loopSwitch = false;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

}
