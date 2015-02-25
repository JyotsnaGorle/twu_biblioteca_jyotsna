package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotsna on 25/02/15.
 */
public class BookList {
    List<Books> bookList = new ArrayList<Books>();
    public BookList(List<Books> books_list){
        System.out.println("im in constructor of booklist");
        this.bookList =books_list;
    }

    public static String viewListOfAllLibraryBooks() {
        String list_to_be_displayed="";
        for(int i=0;i<books_list.size();i++){
            Books each_book = books_list.get(i);
            list_to_be_displayed+= each_book.getTitle()+" "+ each_book.getAuthor()+" "
                    + each_book.getYear_of_publishing();
        }
        return list_to_be_displayed;
    }

    public static BookList create_book_list(){
        System.out.printf("im in create bookList");
        return new BookList(books_list);
    }

    private static List<Books> books_list = new ArrayList<Books>(){{
        System.out.println("im in anonymous class constructor");
        add(Books.createBook("title","author","year"));
    }};

}
