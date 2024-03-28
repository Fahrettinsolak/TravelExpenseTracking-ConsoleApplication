package com.solak.TravelExpenseTracking.Main;

import com.solak.TravelExpenseTracking.Authentication.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("username", "password");
        ConsoleUI consoleUI = new ConsoleUI(user);
        consoleUI.start();
    }
}