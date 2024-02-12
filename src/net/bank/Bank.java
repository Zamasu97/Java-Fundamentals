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
        List<checkingAccount> currentClientAccounts = new ArrayList<checkingAccount>();
        for(checkingAccount account: accountList ){
            if(account.checkUserID(person.getClientID())) {
                currentClientAccounts.add(account);
            }
        }
        return currentClientAccounts;
    }

    public checkingAccount getCurrentClientAccount(Person person, String currentAccountNo)
    {
        List<checkingAccount> clientAccounts = getClientAccounts(person);
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
        if(!checkIfClientExists(name,middleName,surname,age)){
            clients.add(new Person(name, surname, middleName, age, generateClientID(name, middleName, surname)));
        }
    }

    private String generateClientID(String name, String middleName, String surname) {
        int uniqueClientID = new Random().nextInt(999999999);
        String clientID = name.charAt(0) + "" + middleName.charAt(0) + "" + surname.charAt(0) + "" + uniqueClientID;
        return clientID;
    }

    private String generateAccountNo(Person person){
        int uniqueAccountID = new Random().nextInt(999999999);
        return person.getClientID()+"-"+uniqueAccountID;
    }

    //refactor this to getClientByName
    private Boolean checkIfClientExists(String name, String middleName, String surname, int age){
        for(Person client : clients){
            if (clients.isEmpty())
            {
                return false;
            }
            else if(client.getAge()==age && client.getFullName().equals(name + " " + middleName + " " + surname)){
                return true;
            }
        }
        return true;
    }

    protected void openAccount(Person person, double initialDepositAmount){
        if (initialDepositAmount>=minimumOpenAmount){
            accountList.add(new checkingAccount(initialDepositAmount,generateAccountNo(person),person.getClientID()));
        }
    }

    protected void withdrawMoney(Person person, String accNo, double amount){
        checkingAccount account = getCurrentClientAccount(person,accNo);
        if (account.getCurrentBalance() - amount <= -withdrawLimit){
            System.out.println("Can't withdraw over limit");
        }
        else {
            account.decreaseBalance(amount);
        }
    }

    protected void depositMoney(Person person, String accNo, double amount){
        checkingAccount account = getCurrentClientAccount(person,accNo);
        account.increaseBalance(amount);
    }
    protected Person getClientByName(String name, String middleName, String surname){

    }
}
