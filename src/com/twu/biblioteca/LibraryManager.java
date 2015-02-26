package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyotsna on 25/02/15.
 */
public class LibraryManager {
    LibraryManager(){

    }
    public static void main(String[] args) throws IOException {
        LibraryManager manager = new LibraryManager();
        manager.displayMenu();

    }


    private void displayMenu() throws IOException {
        int choice;
        Customer customer = new Customer();

        System.out.printf("Your Options to View:" +
                "\n 1. List Library Books\n" +
                "\n 2. Checkout\n" +
                "\n 3. Return book \n" +
                "\n 0. Exit\n");
        do {
            choice = customer.getChoice();
            try {
                selectOption(customer,choice);
            } catch (Invalid_choice_exception e) {
                System.out.println("Oops! invalid choice,please Renter");
            }
        } while (choice != 0);
    }

    public void selectOption(Customer customer, int choice) throws IOException {
        BibliotecaLibrary bibliotecaApp = new BibliotecaLibrary();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        switch (choice) {
            case 1: {
                bibliotecaApp.viewLibraryBookList();
                displayMenu();
                break;
            }
            case 2: {
                System.out.println("Enter Book Name");
                String bookName = read.readLine();
                customer.borrowBook(bookName);
                DisplayCustomerListAndHandleEmptyCustomerList(customer);
                break;
            }

            case 3:{
                System.out.println("Enter Book Name");
                String bookName = read.readLine();
                customer.returnBook(bookName);
                DisplayCustomerListAndHandleEmptyCustomerList(customer);
                break;
            }


            case 0: {
                System.exit(0);
            }
            default: {
                throw new Invalid_choice_exception();
            }
        }
    }

    private void DisplayCustomerListAndHandleEmptyCustomerList(Customer customer) throws IOException {
        try {
            System.out.println("my books List");
            customer.displayMyBookList();
        } catch (customerBookListEmptyException e) {
            System.out.println("your book list is empty");
            displayMenu();
        }
    }
}