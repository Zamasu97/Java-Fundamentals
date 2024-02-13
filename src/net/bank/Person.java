package net.bank;

public class Person {

    private final String name;
    private final String surname;
    private final String middleName;
    private final int age;

    private final String clientID;


    public Person(String name, String surname, String middleName, int age, String clientID) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.clientID = clientID;
    }

    public String getFullName()
    {
        return name + " " + middleName + " " + surname;
    }
    public int getAge()
    {
        return age;
    }
    public String getClientID(){
        return clientID;
    }

}
