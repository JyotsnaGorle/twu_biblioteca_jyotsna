package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */

public class Customer {
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    BibliotecaLibrary library = new BibliotecaLibrary();
    public String openBiblioteca() {
        return BibliotecaLibrary.openApp();
    }

    public int getChoice() throws IOException {
        return Integer.parseInt(read.readLine());
    }


    public List<Book> borrowBook(String book_name) {
        Book borrowed_book = library.is_book_available(book_name);
        return library.checkout(book_name);

    }

}
