package net.trivia;

public class initQnAs {
    private final String question;
    private final String answer;

    public initQnAs(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public static String[] createArrayList(String question, String answer)
    {
        String[] newSet = new String[2];
        newSet[0] = question;
        newSet[1] = answer;
        return newSet;
    }
}
