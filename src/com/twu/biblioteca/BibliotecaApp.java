package com.twu.biblioteca;

import java.io.IOException;

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

    public static void main(String[] args) throws IOException {
        BookLibrary bookLibrary = new BookLibrary();
        MovieLibrary movieLibrary = new MovieLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp( new ConsoleIODevice());
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
                    "\n 5. View Library Movie List" +
                    "\n 6. Checkout Movie" +
                    "\n 7. View My Movie List" +
                    "\n 0. Exit");
            choice = Integer.parseInt(inputOutputManager.getInput());
                if(choice<=4)
                    iLibrary = new BookLibrary();
            else iLibrary = new MovieLibrary();
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

            case 5:{
                inputOutputManager.writeOutput("Item ID    Title    Author/Director Name   Year");
                iLibrary.display();
                displayMenu(customer);
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
        if(itemType.equals("m")){
            inputOutputManager.writeOutput("this functionality is not yet available");
            return;
        }
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