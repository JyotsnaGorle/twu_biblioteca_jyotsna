package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by jyotsna on 09/03/15.
 */
public class Menu {

    public static HashMap<Integer, IMenuItem> createMenu(BookLibrary bookLibrary, MovieLibrary movieLibrary){
        HashMap<Integer,IMenuItem> menuOptions = new HashMap<Integer, IMenuItem>();
        menuOptions.put(1,new Display(bookLibrary));
        menuOptions.put(2, new CheckoutItem(bookLibrary));
        menuOptions.put(3, new ReturnItem(bookLibrary));

        return menuOptions;
    }

}
