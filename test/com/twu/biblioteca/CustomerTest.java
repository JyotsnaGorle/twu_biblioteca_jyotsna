package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;

public class CustomerTest{

    @Test
    public void isCustomerCheckoutSuccessful(){
        BookLibrary library = new BookLibrary();
        Customer customer = new Customer();
        Book book = (Book)library.checkout(customer,"1");
        Assert.assertThat(customer.borrowBook(book), hasItem(book));
    }

    @Test(expected = InvalidItemException.class)
    public void isCustomerBookListEmptyOrNot(){
        Customer customer= new Customer();
        customer.displayMyItemList("b");
    }

    @Test
    public void isReturnSuccessful(){
        BookLibrary library = new BookLibrary();
        Customer customer= new Customer();
        library.checkout(customer,"1");
        Book returnedBook = customer.returnBook("1");
        Assert.assertThat(customer.getMyBookList(), not(hasItem(returnedBook)));
    }
    @Test
    public void isMovieBorrowedSuccessfuly(){
        Customer customer = new Customer();
        MovieLibrary movieLibrary = new MovieLibrary();
        Movie borrowedMovie = (Movie) movieLibrary.checkout(customer,"1");
        Assert.assertThat(customer.borrowMovie(borrowedMovie),hasItem(borrowedMovie));
    }


}