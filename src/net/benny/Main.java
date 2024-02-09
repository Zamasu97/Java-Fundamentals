package net.benny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        testObject obj1 = new testObject("test", 22, false);
        obj1.method();
        System.out.println(obj1.getClass());
    }
}