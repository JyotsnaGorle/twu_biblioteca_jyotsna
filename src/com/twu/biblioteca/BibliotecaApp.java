package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {
    BibliotecaApp(){

    }
    public static void main(String[] args) throws IOException {
        BibliotecaApp manager = new BibliotecaApp();
        BibliotecaLibrary bibliotecaApp = new BibliotecaLibrary();
        Customer customer = new Customer();
        manager.displayMenu(bibliotecaApp,customer);

    }


    private void displayMenu(BibliotecaLibrary bibliotecaApp, Customer customer) throws IOException {
        int choice;

        do {
            System.out.printf("Your Options to View:" +
                "\n 1. List Library Books" +
                "\n 2. Checkout" +
                "\n 3. Return book" +
                "\n 4. View My Book List" +
                "\n 0. Exit");

            choice = customer.getChoice();

                selectOption(bibliotecaApp,customer, choice);
            }while (choice!=0);


    }

    public void selectOption(BibliotecaLibrary bibliotecaApp, Customer customer, int choice) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        switch (choice) {
            case 1: {
                System.out.println("Book ID   Book Title    Author Name   Year Published");
                bibliotecaApp.viewLibraryBookList();
                displayMenu(bibliotecaApp, customer);
                break;
            }
            case 2: {
                System.out.println("Enter Book Id");
                String bookId = read.readLine();
                Book checkedBook = bibliotecaApp.checkout(bookId);
                if(checkedBook!=null){
                customer.borrowBook(checkedBook);
                displayMenu(bibliotecaApp, customer);
                break;
                }
                else {
                    System.out.println("invalid book");
                    break;
                }
            }

            case 3:{
                if(customer.getMyBookList().isEmpty()){
                    System.out.println("your book list is empty");
                    displayMenu(bibliotecaApp, customer);
                    break;
                }
                System.out.println("Enter Book Id");
                String bookId = read.readLine();
                Book returnedBook = customer.returnBook(bookId);
                if(returnedBook!=null){
                    bibliotecaApp.returnBook(returnedBook);
                    displayMenu(bibliotecaApp,customer);
                    break;
                }
                else {
                    System.out.println("you don't have this book");
                break;
                }
            }

            case 4:{
                try {
                    customer.displayMyBookList();
                }catch (customerBookListEmptyException e){
                    System.out.println("your book list is empty");
                    displayMenu(bibliotecaApp, customer);
                }
                break;
            }
            case 0: {
                System.exit(0);
            }
            default: {
                System.out.println("Oops! invalid choice,please Renter");
                break;
            }
        }
    }



}