package net.benny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TRIVIA GAME!");
        String questionA = "What's the name of the main character from the Legend of Zelda series? ";
        String answerA = "Link";
        String questionB = "Which day of the week is dedicated to the Nordic god Tyr? ";
        String answerB = "Tuesday";
        String questionC = "How many hydrogen atoms are in one water particle? ";
        String answerC = "2";

        int point = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println(questionA);

        String userAnswer1 = myScanner.next();

        if(userAnswer1.equalsIgnoreCase(answerA)){
            point += 1;
            System.out.println("Correct! You now have " + point + " points!");
        }
        else {
            System.out.println("Nope! Correct answer was " + answerA + ". You have " + point + " points");
        }

        System.out.println(questionB);

        String userAnswer2 = myScanner.next();

        if(userAnswer2.equalsIgnoreCase(answerB)){
            point += 1;
            System.out.println("Correct! You now have " + point + " points!");
        }
        else {
            System.out.println("Nope! Correct answer was " + answerB + ". You have " + point + " points");
        }

        System.out.println(questionC);

        String userAnswer3 = myScanner.next();

        if(userAnswer3.equalsIgnoreCase(answerC)){
            point += 1;
            System.out.println("Correct! You now have " + point + " points!");
        }
        else {
            System.out.println("Nope! Correct answer was " + answerC + ". You have " + point + " points");
        }

        switch (point){
            case 3: System.out.println("Perfect score!"); break;
            case 2: System.out.println("Good enough"); break;
            case 1: System.out.println("meh"); break;
            case 0: System.out.println("sussy baka"); break;
            default: System.out.println("Congrats! You broke the code!!"); break;
        }

    }
}