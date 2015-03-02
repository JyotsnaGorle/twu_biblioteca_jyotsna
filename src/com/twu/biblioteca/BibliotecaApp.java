package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {

    private InputOutputManager inputOutputManager;
    private BookLibrary library;

    public BibliotecaApp(InputOutputManager inputOutputManager) {
        this.inputOutputManager = inputOutputManager;
    }

    public BibliotecaApp(BookLibrary library, InputOutputManager inputOutputManager) {
        this(inputOutputManager);
        this.library = library;
    }

    public static void main(String[] args) throws IOException {
        BookLibrary library = new BookLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library,new ConsoleIODevice());
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
                inputOutputManager.writeOutput("Book ID   Book Title    Author Name   Year Published");
                library.viewLibraryBookList();
                displayMenu(customer);
                break;
            }
            case 2: {
                checkOutBook(customer);
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
                    customer.displayMyBookList();
                }catch (InvalidBookException e){
                    inputOutputManager.writeOutput("-------your book list is empty---------");
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



    void checkOutBook(Customer customer) throws IOException {
        inputOutputManager.writeOutput("Enter Book Id");
        String bookId = inputOutputManager.getInput();
        Book checkedBook = library.checkout(bookId,customer);
        if(checkedBook!=null){
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE BOOK " + checkedBook.getTitle());
            return;
        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid book------");
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
        Book returnedBook = library.returnBook(bookId,customer);
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