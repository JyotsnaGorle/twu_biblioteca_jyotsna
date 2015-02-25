package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class Customer {
List<Books> myBookList = new ArrayList<Books>();
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public String openBiblioteca() {
         BibliotecaApp library = new BibliotecaApp();
        return library.openApp();
    }

    public void selectOption(int choice) throws IOException {
        switch (choice){
            case 1:
            {
                System.out.println(BookList.viewListOfAllLibraryBooks());
                break;
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


    public String checkout() {
        return "successful checkout";
    }
}
