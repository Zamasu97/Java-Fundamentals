package net.benny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double var = scanner.nextDouble();
        //((Object) var).getClass().getName();
        System.out.println(((Object) var).getClass().getName());
    }
}