package net.benny;

import java.util.Scanner;

public class loopetyloo {
    public static void main(String[] args)
    {
        String[] qst = {"What is your name? ", "What is your quest? ", "What is the capital of Assyria? ",
                "What is your favourite colour? ", "What is the air-speed velocity of an unladen swallow? (in kmph)  "};
        String[] ans = {"Arthur", "Grail", "Assur", "Blue", "32.4"};
        int points = 0;
        Scanner contQuery = new Scanner(System.in);

        while (true){
            System.out.println("Welcome to the show!");
            for(int i = 0; i< qst.length; i++)
            {
                String currUsrAns = printQuestionsGetAnswer(qst[i]);
                points = gradeAnswer(currUsrAns, ans[i], points);
            }
            System.out.println("Your points total is: " + points);
            System.out.println("Would you like to continue playing? Y/N (default)");
            if(contQuery.next().equalsIgnoreCase("Y"))
            {
                points = 0;
                System.out.println("Your points has been erased by King Crimson!");
            }
            else
            {
                System.out.println("Thank you and goodnight!");
                break;
            }
        }

    }

    public static String printQuestionsGetAnswer(String question){
        Scanner getInput = new Scanner(System.in);
        System.out.println(question);
        return getInput.next();
    }
    public static int gradeAnswer(String userAnswer, String currAns, int CurrPoint){
        if (userAnswer.equalsIgnoreCase(currAns)){
            CurrPoint++;
            System.out.println("Correct! You now have "+ CurrPoint + " points!");
        }
        else{
            System.out.println("Incorrect! Correct answer was " + currAns);
        }
        return CurrPoint;
    }
}
