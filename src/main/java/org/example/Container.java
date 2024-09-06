package org.example;

import org.example.db.DBConnection;

import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;

    public static void init() {
        sc = new Scanner(System.in);
        System.out.println("== 게시판 앱 ==");
        System.out.println("로그인 해주세요. (아이디가 없다면 회원가입 해주세요)");
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}