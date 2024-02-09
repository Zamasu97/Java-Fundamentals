package net.benny;

import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

public class collections {
    public static void main(String[] args)
    {
        List<String> questionList = new ArrayList<>();
        questionList.add("q1");
        questionList.add("q2");
        questionList.add("q3");
        questionList.add("q4");

        questionList.remove(1);
        questionList.remove("q4");

        System.out.println(questionList.size());
        System.out.println(questionList.get(0));
    }

}