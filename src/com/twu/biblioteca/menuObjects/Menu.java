package com.twu.biblioteca.menuObjects;

import com.twu.biblioteca.*;

import java.util.HashMap;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Menu {

    public static HashMap<Integer, IMenuItem> createMenu(BookLibrary bookLibrary, MovieLibrary movieLibrary){
        HashMap<Integer,IMenuItem> menuOptions = new HashMap<Integer, IMenuItem>();
        menuOptions.put(1,new DisplayBookList(bookLibrary));
        menuOptions.put(2, new CheckoutBook(bookLibrary));
        menuOptions.put(3, new ReturnItem(bookLibrary));
        menuOptions.put(4, new DisplayMyBookList(bookLibrary));
        menuOptions.put(5, new DisplayMovieList(movieLibrary));
        menuOptions.put(6, new CheckoutMovie(movieLibrary));
        menuOptions.put(9, new Logout());
        menuOptions.put(0, new Exit());



        return menuOptions;
    }

}
