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
        Customer customer = new Customer();
        manager.displayMenu(customer);

    }


    private void displayMenu(Customer customer) throws IOException {
        int choice;

        do {
            System.out.printf("Your Options to View:" +
                "\n 1. List Library Books" +
                "\n 2. Checkout" +
                "\n 3. Return book" +
                "\n 4. View My Book List" +
                "\n 0. Exit");

            choice = customer.getChoice();

                selectOption(customer, choice);
            }while (choice!=0);


    }

    public void selectOption(Customer customer, int choice) throws IOException {
        BibliotecaLibrary bibliotecaApp = new BibliotecaLibrary();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        switch (choice) {
            case 1: {
                System.out.println("Book ID   Book Title    Author Name   Year Published");
                bibliotecaApp.viewLibraryBookList();
                displayMenu(customer);
                break;
            }
            case 2: {
                System.out.println("Enter Book Id");
                int bookId = Integer.parseInt(read.readLine());
                Book checkedBook = bibliotecaApp.checkout(bookId);
                customer.borrowBook(checkedBook);
                bibliotecaApp.viewLibraryBookList();
                displayMenu(customer);
                break;
            }

            case 3:{
                if(customer.getMyBookList().isEmpty()){
                    System.out.println("your book list is empty");
                    displayMenu(customer);
                    break;
                }
                System.out.println("Enter Book Id");
                int bookId = Integer.parseInt(read.readLine());
                Book returnedBook = customer.returnBook(bookId);
                bibliotecaApp.returnBook(returnedBook);
                break;
            }

            case 4:{
                try {
                    customer.displayMyBookList();
                }catch (customerBookListEmptyException e){
                    System.out.println("your book list is empty");
                    displayMenu(customer);
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