package com.twu.biblioteca;

import com.twu.biblioteca.domainObjects.Admin;
import com.twu.biblioteca.domainObjects.Book;
import com.twu.biblioteca.domainObjects.Movie;
import com.twu.biblioteca.inputOutputDevice.ConsoleIODevice;
import com.twu.biblioteca.inputOutputDevice.InputOutputManager;
import com.twu.biblioteca.menuObjects.IMenuItem;
import com.twu.biblioteca.menuObjects.Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyotsna on 25/02/15.
 */

public class BibliotecaApp {

    private InputOutputManager inputOutputManager;
    private LibraryMemberCredentials libraryMemberCredentials;
    private HashMap<Integer,IMenuItem> menu;



    public BibliotecaApp(InputOutputManager inputOutputManager, BookLibrary bookLibrary, MovieLibrary movieLibrary) {
    this.inputOutputManager = inputOutputManager;
        this.menu = Menu.createMenu(bookLibrary, movieLibrary);
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
        if(!userId.equals("admin")){
            LibraryMember loggedInMember;
            do{
                loggedInMember = userLogin(userId);

            }while (loggedInMember==null);
            selectOption(loggedInMember, bookLibrary, movieLibrary);
        }
        else adminLogin(userId,bookLibrary,movieLibrary);

    }

    public void selectOption(LibraryMember loggedInMember, BookLibrary bookLibrary, MovieLibrary movieLibrary) throws IOException {
        int choice,result=0;
        do {
            displayMenu();
            inputOutputManager.writeOutput("Enter your choice");
            choice = Integer.parseInt(inputOutputManager.getInput());
            if(choice<=9)
            result = menu.get(choice).executeAction(loggedInMember, inputOutputManager);
            else inputOutputManager.writeOutput("invalid choice renter");
        }while (result!=1 && result!=9);

        if(result==9){
            startApp(bookLibrary,movieLibrary);
        }
    }

    private void adminLogin(String adminId, BookLibrary bookLibrary, MovieLibrary movieLibrary) throws IOException {
        Admin admin = new Admin();
        inputOutputManager.writeOutput("enter pwd");
        String pwd = inputOutputManager.getInput();// en-US, hi, ka, fr, de.properties,
        if(admin.adminLogin(adminId,pwd)){
            inputOutputManager.writeOutput("admin logged in");
            if(!bookLibrary.borrowedBooks.isEmpty())
            {
                for(Map.Entry<String,Book> each : bookLibrary.borrowedBooks.entrySet()){
                    inputOutputManager.writeOutput(each.getValue().getTitle()+" "+each.getValue().getAuthor()+" "+each.getValue().getBookId()+" "+each.getValue().getAuthor()+" "+each.getKey());
                }
            }
            if(!movieLibrary.borrowedMovies.isEmpty()){
                for(Map.Entry<String,Movie> each : movieLibrary.borrowedMovies.entrySet()){
                    inputOutputManager.writeOutput(each.getValue().getTitle()+" "+each.getValue().getDirector()+" "+each.getValue().getMovieId()+" "+each.getKey());
                }
            }
            else inputOutputManager.writeOutput("nothing borrowed yet");
            return;
        }
        else inputOutputManager.writeOutput("Wrong Credentials");
    }


    private LibraryMember userLogin(String userId) throws IOException {
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