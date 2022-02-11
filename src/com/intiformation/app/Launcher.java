package com.intiformation.app;
import com.intiformation.app.util.ConnectionManager;
import java.sql.Connection;
import java.util.Scanner;

public class Launcher {
    public static Scanner scna = new Scanner(System.in);

    public static void main(String[] args) {

        Connection myConnection = ConnectionManager.getConnection();


        System.out.println("Welcome abord !");


        System.out.println("1 - Add a place");
        System.out.println("2 - Find a place");
        System.out.println("3 - Edit a place");
        System.out.println("4 - Remove a place");
        System.out.println("5 - Add a trip");
        System.out.println("6 - Find a trip");
        System.out.println("7 - Remoove a trip");
        System.out.println("8 - Quit");




	// write your code here
    }
}
