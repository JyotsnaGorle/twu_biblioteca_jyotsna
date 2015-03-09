package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {

    private InputOutputManager inputOutputManager;
    private LibraryMemberCredentials libraryMemberCredentials;
    private String userId;
    private HashMap<Integer,IMenuItem> menu;



    public BibliotecaApp(InputOutputManager inputOutputManager, BookLibrary bookLibrary, MovieLibrary movieLibrary) {
    this.inputOutputManager = inputOutputManager;
        this.menu = Menu.createMenu(bookLibrary,movieLibrary);
    }

    public static void main(String[] args) throws IOException {
        BookLibrary bookLibrary = new BookLibrary();
        MovieLibrary movieLibrary = new MovieLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp( new ConsoleIODevice(),bookLibrary,movieLibrary);
        bibliotecaApp.startApp(bookLibrary,movieLibrary);

    }


    public void startApp(BookLibrary bookLibrary, MovieLibrary movieLibrary) throws IOException {
        inputOutputManager.writeOutput("-------WELCOME TO BIBLIOTECA--------");
        inputOutputManager.writeOutput("Enter UserId");
        String userId = inputOutputManager.getInput();
        this.userId=userId;
        if(!userId.equals("admin")){
            LibraryMember loggedInMember;
            do{
                loggedInMember = userLogin();

            }while (loggedInMember==null);
            SelectOption(loggedInMember);
        }
        else adminLogin(userId,bookLibrary,movieLibrary);

    }

    private void SelectOption(LibraryMember loggedInMember) throws IOException {
        int choice;
        do {
            displayMenu();
            inputOutputManager.writeOutput("Enter your choice");
            choice = Integer.parseInt(inputOutputManager.getInput());
            if(choice>9)
                inputOutputManager.writeOutput("invalid choice");
            menu.get(choice).executeAction(loggedInMember, inputOutputManager);
        }while (choice !=9);
    }

    private void adminLogin(String adminId, BookLibrary bookLibrary, MovieLibrary movieLibrary) throws IOException {
        Admin admin = new Admin();
        inputOutputManager.writeOutput("enter pwd");
        String pwd = inputOutputManager.getInput();
        if(admin.adminLogin(adminId,pwd)){
            inputOutputManager.writeOutput("admin logged in");
            if(!bookLibrary.borrowedBooks.isEmpty())
            {
                for(Map.Entry<String,Book> each : bookLibrary.borrowedBooks.entrySet()){
                    inputOutputManager.writeOutput(each.getValue().getTitle()+" "+each.getValue().getAuthor()+" "+each.getValue().getBookId()+" "+each.getValue().getAuthor()+" "+each.getKey());
                }
            }
            else inputOutputManager.writeOutput("nothing borrowed yet");
            return;
        }
        else inputOutputManager.writeOutput("Wrong Credentials");
    }


    private LibraryMember userLogin() throws IOException {
        inputOutputManager.writeOutput("Enter password");
        String pwd = inputOutputManager.getInput();
        libraryMemberCredentials = new LibraryMemberCredentials();
        LibraryMember loggedInUser = libraryMemberCredentials.getCustomer(userId, pwd);
        if(loggedInUser!=null)
            return loggedInUser;
        else {
            inputOutputManager.writeOutput("invalid credentials");
            return null;
        }

    }


    public void displayMenu() throws IOException {

        for (Map.Entry<Integer,IMenuItem> each : menu.entrySet()){
            inputOutputManager.writeOutput(String.valueOf(each.getKey())+ ". "+each.getValue().displayMenuItem());
        }
    }


}