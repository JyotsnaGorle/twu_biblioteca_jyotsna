package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args)throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.openApp();
        BookList.create_book_list();

        bibliotecaApp.displayMenu();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int choice = Integer.parseInt(read.readLine());
        Customer customer = new Customer();
        try {
            customer.selectOption(choice);
         }
        catch (Invalid_choice_exception e){
            System.out.println("Oops! invalid choice,please Renter");
            choice = Integer.parseInt(read.readLine());
            customer.selectOption(choice);
        }

    }

    private void displayMenu() {
        System.out.printf("Your Options to View:" +
                "\n 1. List Books"+
                   "\n 0. Exit\n" );
        }

    public String openApp() {
        System.out.println("Welcome User");
        return "welcome";
    }

    public String viewList() {
        return BookList.viewListOfAllLibraryBooks();
    }
}
