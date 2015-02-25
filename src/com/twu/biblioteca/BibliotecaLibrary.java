package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaLibrary {
    static Customer customer = new Customer();

    public static void main(String[] args)throws IOException {
        BibliotecaLibrary bibliotecaApp = new BibliotecaLibrary();
        bibliotecaApp.openApp();
        BookList.create_book_list();

        bibliotecaApp.displayMenu();
}

    public  static void selectOption(int choice) throws IOException {
        switch (choice){
            case 1:
            {
                System.out.println(BookList.viewListOfAllLibraryBooks());
                break;
            }
            case 2:{
                try{
                customer.displayMyBookList();
                System.out.println("my books List");
                }
                catch (Customer_book_list_is_empty_exception e){
                    System.out.println("your book list is empty");
                    displayMenu();
                }
            }
            case 0:
            {
                System.exit(0);
            }
            default:{
                throw new Invalid_choice_exception();
            }
        }
    }

    private static void displayMenu() throws IOException {
        int choice;

        System.out.printf("Your Options to View:" +
                "\n 1. List Library Books\n"+
                "\n 2. List My Books\n"+
                "\n 3. Checkout\n"+
                "\n 2. Return book \n"+
                   "\n 0. Exit\n" );
            do {
                choice= customer.getChoice();
                try {
                    selectOption(choice);
                }
                catch (Invalid_choice_exception e){
                    System.out.println("Oops! invalid choice,please Renter");
                }
            } while (choice!=0);
        }

    public String openApp() {
        System.out.println("Welcome User");
        return "welcome";
    }

    public String viewList() {
        return BookList.viewListOfAllLibraryBooks();
    }
}
