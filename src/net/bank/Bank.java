package net.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private static final double withdrawLimit = 1000;
    private static final double minimumOpenAmount = 500;
    private final String bankName;
    private final List<checkingAccount> accountList;
    private final List<Person> clients;

    public Bank(String bankName) {
        this.bankName = bankName;
        accountList = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public List<checkingAccount> getClientAccounts(Person person){
        List<checkingAccount> currentClientAccounts = new ArrayList<>();
        for(checkingAccount account: accountList ){
            if(account.checkUserID(person.getClientID())) {
                currentClientAccounts.add(account);
            }
        }
        return currentClientAccounts;
    }

    public List<Person> getAllClients(){
        return clients;
    }

    public checkingAccount getCurrentClientAccount(String clientID, String currentAccountNo)
    {
        List<checkingAccount> clientAccounts = getClientAccounts(getClientByID(clientID));
        for (checkingAccount acc : clientAccounts)
        {
            if (acc.getAccountNo().equals(currentAccountNo))
            {
                return acc;
            }
        }
        return null;
    }

    protected void createClient(String name, String middleName, String surname, int age){
        if(getClient(name,middleName,surname,age) == null){
            clients.add(new Person(name, surname, middleName, age, generateClientID(name, middleName, surname)));
            System.out.println("Client created");
        }
    }

    private String generateClientID(String name, String middleName, String surname) {
        int uniqueClientID = new Random().nextInt(999999999);
        return name.charAt(0) + "" + middleName.charAt(0) + surname.charAt(0) + uniqueClientID;
    }

    private String generateAccountNo(Person person){
        int uniqueAccountID = new Random().nextInt(999999999);
        return person.getClientID()+"-"+uniqueAccountID;
    }


    protected void openAccount(Person person, double initialDepositAmount){
        if (initialDepositAmount>=minimumOpenAmount && person != null){
            accountList.add(new checkingAccount(initialDepositAmount,generateAccountNo(person),person.getClientID()));
        }
        else if (person == null){
            System.out.println("Couldn't find person in db");
        }
        else{
            System.out.println("Not enough initial deposit");
        }
    }

    //refactor these 2 to not use CID but get CID from AccNo
    protected void withdrawMoney(String clientID, String accNo, double amount){
        checkingAccount account = getCurrentClientAccount(clientID,accNo);
        if (account.getCurrentBalance() - amount <= -withdrawLimit){
            System.out.println("Can't withdraw over limit");
        }
        else {
            account.decreaseBalance(amount);
        }
    }

    protected void depositMoney(String clientID, String accNo, double amount){
        checkingAccount account = getCurrentClientAccount(clientID,accNo);
        account.increaseBalance(amount);
    }
    protected Person getClient(String name, String middleName, String surname, int age){
        for (Person client : clients)
        {
            if(client.getAge()==age && client.getFullName().equals(name + " " + middleName + " " + surname)){
                return  client;
            }
        }
        return null;
    }

    protected Person getClientByID(String clientID){
        for (Person client : clients)
        {
            if(client.getClientID().equals(clientID)){
                return  client;
            }
        }
        return null;
    }

    protected String getBankName(){
        return bankName;
    }
}
