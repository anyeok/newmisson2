package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
        System.out.println("== 게시판 앱 ==");
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }
}