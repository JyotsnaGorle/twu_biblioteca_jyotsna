package com.twu.biblioteca;

import java.io.IOException;

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
                "\n 2. List My Books\n" +
                "\n 3. Checkout\n" +
                "\n 4. Return book \n" +
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

        switch (choice) {
            case 1: {
                bibliotecaApp.viewLibraryBookList();
                bibliotecaApp.is_book_available("book1");
                break;
            }
            case 2: {
                try {
                    customer.displayMyBookList();
                    System.out.println("my books List");
                } catch (customerBookListEmptyException e) {
                    System.out.println("your book list is empty");
                    displayMenu();
                }
                break;
            }
            case 3: {
                customer.borrowBook("book1");
                displayMenu();
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
}