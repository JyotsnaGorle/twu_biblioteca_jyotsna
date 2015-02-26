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
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    //non static becoz each customer will have his own book list
      List<Book> myBookList = new ArrayList<Book>();
    public String openBiblioteca() {
    return BibliotecaLibrary.openApp();
    }

    public int getChoice() throws IOException {
        return Integer.parseInt(read.readLine());
    }


    public List<Book> borrowBook(String book_name) {
        Book checkedBook = BibliotecaLibrary.checkout(book_name);
        myBookList.add(checkedBook);
        System.out.println("successful checkout");
        return myBookList;
    }


    public void displayMyBookList() {
        if(myBookList.isEmpty()){
            throw new customerBookListEmptyException();
        }
        else {
            for(Book eachBook :myBookList)
                System.out.println(eachBook.getTitle()+" "+eachBook.getAuthor()+eachBook.getYearOfPublishing());
        }
    }

    public Book isBookWithMe(String bookName) {
        for(Book each: myBookList){
            if(each.getTitle().equals(bookName))
                return each;
        }
        return null;
    }

    public List<Book> returnBook(String bookName) {
        Book bookToBeReturned = isBookWithMe(bookName);
        if(bookToBeReturned!=null){
            BibliotecaLibrary.returnBook(bookToBeReturned);
            myBookList.remove(bookToBeReturned);

        }
        return myBookList;
    }
}
