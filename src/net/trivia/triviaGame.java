package net.trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class triviaGame {
    private final String[] qst = {"What is your name? ", "What is your quest? ", "What is the capital of Assyria? ",
            "What is your favourite colour? ", "What is the air-speed velocity of an unladen swallow? (in kmph)  "};
    private final String[] ans = {"Arthur", "Grail", "Assur", "Blue", "32.4"};
    private final Scanner contQuery = new Scanner(System.in);
    private final List<String[]> QnAset = new ArrayList<>();

    public triviaGame() {

    }

    private void fillQnAs(){
        for(int i = 0; i < qst.length; i++){
            QnAset.add(initQnAs.createArrayList(qst[i],ans[i]));
        }
    }

    public void mainloop()
    {
        int points = 0;

        fillQnAs();
        while(true)
        {
            System.out.println("Welcome to the show!");
            for (String[] strings : QnAset) {
                Scanner getInput = new Scanner(System.in);
                System.out.println(strings[0]);
                if (getInput.next().equalsIgnoreCase(strings[1])) {
                    points++;
                    System.out.println("Correct! You have now " + points + " points!");
                } else {
                    System.out.println("Inccorrect! Correct answer was " + strings[1]);
                }
            }
            System.out.println("Your final score is " + points + " points");
            System.out.println("Would you like to continue playing? Y/N (default)");
            if(contQuery.next().equalsIgnoreCase("Y")){
                points = 0;
                System.out.println("Your points has ben reset to 0, continuing");
            }
            else {
                System.out.println("Thank you and goodnight!");
                break;
            }
        }

    }
}
