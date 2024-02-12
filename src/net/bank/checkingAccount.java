package net.bank;

public class checkingAccount {
    private double currentBalance;
    private final String accountNo;
    private final String accountOwnerID;

    public checkingAccount(double currentBalance, String accountNo, String accountOwnerID) {
        this.currentBalance = currentBalance;
        this.accountNo = accountNo;
        this.accountOwnerID = accountOwnerID;
    }

    protected void increaseBalance(double amount)
    {
        if (amount>=0){
            currentBalance+=amount;
        }
        else {
            System.out.println("increaseBalance method only accepts positive values!");
        }
    }
    protected void decreaseBalance(double amount){
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

    public boolean checkUserID(String UIDToCheck)
    {
        return UIDToCheck.equals(accountOwnerID);
    }
}
