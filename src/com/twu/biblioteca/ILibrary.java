package com.twu.biblioteca;

/**
 * Created by jyotsna on 02/03/15.
 */
public interface ILibrary {
    public Object find(String itemId);
    public void display();
    public Object checkout(LibraryMember libraryMember, String itemId);
    public Object returnItem(LibraryMember libraryMember, String bookId);

    }
