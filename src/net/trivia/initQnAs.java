package net.trivia;

public class initQnAs {

    public initQnAs() {
    }

    public static String[] createArrayList(String question, String answer)
    {
        String[] newSet = new String[2];
        newSet[0] = question;
        newSet[1] = answer;
        return newSet;
    }
}
