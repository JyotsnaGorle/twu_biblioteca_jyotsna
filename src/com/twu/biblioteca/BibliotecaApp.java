package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {

    private InputOutputManager inputOutputManager;
    private ILibrary iLibrary;
    private UserCredentials userCredentials;
    private String userId;

List<Item> borrowedItems = new ArrayList<Item>();

    public BibliotecaApp(InputOutputManager inputOutputManager) {
    this.inputOutputManager = inputOutputManager;
    }

    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp( new ConsoleIODevice());
        bibliotecaApp.startApp();
    }


    public void startApp() throws IOException {
        inputOutputManager.writeOutput("-------WELCOME TO BIBLIOTECA--------");
        inputOutputManager.writeOutput("Enter UserId");
        String userId = inputOutputManager.getInput();
        this.userId=userId;
        if(!userId.equals("admin")){
            Boolean loginStatus;
            do{
                loginStatus = userLogin();
            }while (!loginStatus);

            LibraryMember libraryMember = new LibraryMember();
            displayMenu(libraryMember, new BookLibrary(), new MovieLibrary());
        }
        else adminLogin(userId);

    }

    private void adminLogin(String adminId) throws IOException {
        Admin admin = new Admin();
        inputOutputManager.writeOutput("enter pwd");
        String pwd = inputOutputManager.getInput();
        if(admin.adminLogin(adminId,pwd)){
            inputOutputManager.writeOutput("admin logged in");
            if(!borrowedItems.isEmpty())
            viewBorrowedItems();
            else inputOutputManager.writeOutput("nothing borrowed yet");
            return;
        }
        else inputOutputManager.writeOutput("Wrong Credentials");
    }

    private void viewBorrowedItems() {
        for(Item each : borrowedItems){
            inputOutputManager.writeOutput(each.getItemInfo());
        }
    }

    private Boolean userLogin() throws IOException {
        inputOutputManager.writeOutput("Enter password");
        String pwd = inputOutputManager.getInput();
        userCredentials = new UserCredentials();
        if(userCredentials.getCustomer(userId,pwd)!=null)
            return true;
        else return false;

    }


    public void displayMenu(LibraryMember libraryMember, BookLibrary bookLibrary, MovieLibrary movieLibrary) throws IOException {
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
                    "\n 8. My Credentials" +
                    "\n 9. LOGOUT");
            choice = Integer.parseInt(inputOutputManager.getInput());
            setiLibraryType(choice, bookLibrary,movieLibrary);
            selectOption(libraryMember, choice);
            }while (choice!=9);


    }

    public void setiLibraryType(int choice, BookLibrary bookLibrary, MovieLibrary movieLibrary) {
        if(choice<=4)
            iLibrary = bookLibrary;
    else iLibrary = movieLibrary;
    }

    public void selectOption(LibraryMember libraryMember, int choice) throws IOException {

        switch (choice) {
            case 1: {
                inputOutputManager.writeOutput("Item ID    Title    Author   Name   Year");
                iLibrary.display();
                break;
            }
            case 2: {
                checkOutItem(libraryMember);
                break;
            }

            case 3:{
                returnBook(libraryMember);
                break;
            }

            case 4:{
                try {
                    libraryMember.displayMyItemList(iLibrary);
                }catch (InvalidItemException e){
                    inputOutputManager.writeOutput("-------your list is empty---------");
                }
                break;
            }

            case 5:{
                inputOutputManager.writeOutput("Item ID    Title    Director   Name   Year");
                iLibrary.display();
                break;
            }
            case 6:
            {
                checkOutItem(libraryMember);
                break;
            }
            case 7:{
                try {
                    libraryMember.displayMyItemList(iLibrary);
                }catch (InvalidItemException e){
                    inputOutputManager.writeOutput("-------your list is empty---------");
                }
                break;
            }
            case 8:{
                User currentUser = userCredentials.getCustomer(userId);
                inputOutputManager.writeOutput("-----Your Credentials-----");
                inputOutputManager.writeOutput("UserId      UserName   Email Id  Phone Number");
                inputOutputManager.writeOutput(currentUser.getCustId()+" "+currentUser.getuName()+" "+currentUser.getEmailId()+" "+currentUser.getPhoneNo());
                break;
            }

            case 9:{
                inputOutputManager.writeOutput("you are logged out");
                startApp();
                break;
            }
            default: {
                inputOutputManager.writeOutput("Oops! invalid choice,please Renter");
                break;
            }
        }
    }



    void checkOutItem(LibraryMember libraryMember) throws IOException {
        inputOutputManager.writeOutput("Enter Item Id");
        String itemId = inputOutputManager.getInput();
        Object checkedItem = iLibrary.checkout(libraryMember,itemId);
        if(checkedItem!=null){
            addToBorrowRecord(checkedItem,userId);
            inputOutputManager.writeOutput("SUCCESSFUL CHECKOUT! ENJOY THE ITEM");
            return;
        }
        else {
            inputOutputManager.writeOutput("------This is an Invalid Item------");
            return;
        }
    }

    public void addToBorrowRecord(Object checkedItem, String userId) {
        if(checkedItem instanceof Book)
            borrowedItems.add(new Item((Book) checkedItem, userId));
        else if(checkedItem instanceof Movie)
            borrowedItems.add(new Item((Movie) checkedItem, userId));
    }

    void returnBook(LibraryMember libraryMember) throws IOException {
        if(iLibrary instanceof MovieLibrary){
            inputOutputManager.writeOutput("this functionality is not yet available");
            return;
        }
        if(libraryMember.getMyBookList().isEmpty()){
            inputOutputManager.writeOutput("---------your book list is empty---------");
            return;
        }
        inputOutputManager.writeOutput("Enter Book Id");
        String bookId = inputOutputManager.getInput();
        Book returnedBook = (Book)iLibrary.returnItem(libraryMember,bookId);
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