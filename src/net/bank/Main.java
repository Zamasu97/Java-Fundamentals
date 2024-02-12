package net.bank;

public class Main {
    public static void main(String[] args){
        Bank bank1 = new Bank("BenBank");
        bank1.createClient("Aa","Be","Ce",22);
        bank1.createClient("De","Ee","Ef", 28);
        bank1.openAccount();
    }
}
