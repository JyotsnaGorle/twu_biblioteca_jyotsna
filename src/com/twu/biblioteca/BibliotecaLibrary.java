package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLibrary {
    List<Book> customerBookList= new ArrayList<Book>();
    static List<Book> libraryBookList = new ArrayList<Book>(){{
        add(Book.createBook("book1","author1","2012"));
        add(Book.createBook("book2","author2","2012"));
        add(Book.createBook("book3","author3","2012"));
        add(Book.createBook("book4", "author4", "2012"));
    }
    };

    public static String openApp() {
        return "welcome";
    }

    public void viewList() {
        for(Book each : libraryBookList){
            System.out.println(each.getTitle()+" "+each.getTitle()+" "+each.getYearOfPublishing());
        }
    }

    public  List<Book> checkout(String book_name) {
//        for(Book each : listOfBooksInLibrary) {
        if(is_book_available(book_name)!=null){
            int size = libraryBookList.size();
            for(int i=0;i<size-1;i++){
                Book each_book = libraryBookList.get(i);
                if(each_book.getTitle().equals(book_name)){
            libraryBookList.remove(each_book);
                    customerBookList.add(each_book);
                    System.out.println("checkout successfull");
                }
            }
        }
        else {
            System.out.println("Book not available");
        }
        return libraryBookList;
        }

    public  Book is_book_available(String book_name) {
        for (Book each : libraryBookList) {
            if (each.getTitle().equals(book_name)) {
                return each;
            }
        }
            return null;
        }
    public void displayMyBookList() {
        if(customerBookList.isEmpty()){
            throw new Customer_book_list_is_empty_exception();
        }
        else {
            for(Book eachBook : customerBookList)
                System.out.println(eachBook.getTitle()+" "+eachBook.getAuthor()+eachBook.getYearOfPublishing());
        }
    }


}

