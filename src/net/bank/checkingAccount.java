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
        currentBalance+=Math.abs(amount);
    }
    protected void decreaseBalance(double amount)
    {
        currentBalance-=Math.abs(amount);
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

    public void printAccountFullDetails(){
        System.out.println("Owner: " + accountOwnerID + ". Account number: " + accountNo + ". Current balance: " + currentBalance);
    }
}
