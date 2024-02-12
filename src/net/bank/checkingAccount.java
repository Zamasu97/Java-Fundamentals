package net.bank;

import java.util.Objects;

public class checkingAccount {
    private double currentBalance;
    private final String accountNo;
    private final Person accountOwner;

    public checkingAccount(double currentBalance, String accountNo, Person accountOwner) {
        this.currentBalance = currentBalance;
        this.accountNo = accountNo;
        this.accountOwner = accountOwner;
    }

    private void increaseBalance(double amount)
    {
        if (amount>=0){
            currentBalance+=amount;
        }
        else {
            System.out.println("increaseBalance method only accepts positive values!");
        }
    }
    private void decreaseBalance(double amount){
        if (amount<0){
            currentBalance+=amount;
        }
        else {
            System.out.println("decreaseBalance method only accepts negative values!");
        }
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public String getAccountNo(){
        return accountNo;
    }

    public boolean checkAccountNo(String accountNoToCheck){
        return accountNoToCheck.equals(accountNo);
    }

    public boolean checkUserID(String UIDToCheck)
    {
        return UIDToCheck.equals(accountOwner.getClientID());
    }
}
