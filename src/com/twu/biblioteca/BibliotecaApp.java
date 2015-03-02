package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {

    private InputOutputManager inputOutputManager;
    private ILibrary iLibrary;
    String itemType;

    public BibliotecaApp(InputOutputManager inputOutputManager) {
        this.inputOutputManager = inputOutputManager;
    }

    public BibliotecaApp(ILibrary iLibrary, InputOutputManager inputOutputManager,String itemType) {
        this(inputOutputManager);
        this.iLibrary = iLibrary;
        this.itemType = itemType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BookLibrary bookLibrary = new BookLibrary();
        MovieLibrary movieLibrary = new MovieLibrary();
        System.out.println("-------WELCOME TO BIBLIOTECA--------");
        System.out.println("What do you want to browse");
        System.out.println("b for Books and m for Movies");
        String itemType = read.readLine();
        BibliotecaApp bibliotecaApp;
        if(itemType.equals("b")){
            bibliotecaApp = new BibliotecaApp(bookLibrary,new ConsoleIODevice(),itemType);

        }
        else {
            bibliotecaApp = new BibliotecaApp(movieLibrary,new ConsoleIODevice(),itemType);

        }
        bibliotecaApp.startApp();
        Customer customer = new Customer();
        bibliotecaApp.displayMenu(customer);
    }

    public void startApp(){
        inputOutputManager.writeOutput("-------WELCOME TO BIBLIOTECA--------");
    }
    private void displayMenu(Customer customer) throws IOException {
        int choice;

        do {
            inputOutputManager.writeOutput("Your Options to View:" +
                    "\n 1. List Library Books" +
                    "\n 2. Checkout" +
                    "\n 3. Return book" +
                    "\n 4. View My Book List" +
                    "\n 0. Exit");
            choice = Integer.parseInt(inputOutputManager.getInput());

                selectOption(customer, choice);
            }while (choice!=0);


    }

    public void selectOption(Customer customer, int choice) throws IOException {

        switch (choice) {
            case 1: {
                inputOutputManager.writeOutput("Item ID    Title    Author/Director Name   Year");
                iLibrary.display();
                displayMenu(customer);
                break;
            }
            case 2: {
                checkOutItem(customer);
                displayMenu(customer);
                break;
            }

            case 3:{
                returnBook(customer);
                displayMenu(customer);
                break;
            }

            case 4:{
                try {
                    customer.displayMyItemList(itemType);
                }catch (InvalidItemException e){
                    inputOutputManager.writeOutput("-------your list is empty---------");
                    displayMenu(customer);
                }
                break;
            }
            case 0: {
                System.exit(0);
            }
            default: {
                inputOutputManager.writeOutput("Oops! invalid choice,please Renter");
                break;
            }
        }
    }



    void checkOutItem(Customer customer) throws IOException {
        inputOutputManager.writeOutput("Enter Book Id");
        String itemId = inputOutputManager.getInput();
        Object checkedItem = iLibrary.checkout(customer,itemId);
        if(checkedItem!=null){
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE ITEM");
            return;
        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid Item------");
            return;
        }
    }

    void returnBook(Customer customer) throws IOException {
        if(customer.getMyBookList().isEmpty()){
            inputOutputManager.writeOutput("---------your book list is empty---------");
            return;
        }
        inputOutputManager.writeOutput("Enter Book Id");
        String bookId = inputOutputManager.getInput();
        Book returnedBook = (Book)iLibrary.returnItem(customer,bookId);
        if(returnedBook!=null){
            inputOutputManager.writeOutput("THANK YOU FOR RETURNING THE BOOK " + returnedBook.getTitle() + "\n");
            return;
        }
        else {
            inputOutputManager.writeOutput("YOU DON'T HAVE THIS BOOK");
            return;
        }
    }

}