package net.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final double withdrawLimit = 1000;
    private static final double minimumOpenAmount = 500;
    private String bankName;
    private List<checkingAccount> accountList;

    public Bank(String bankName) {
        this.bankName = bankName;
        accountList = new ArrayList<>();
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
}
