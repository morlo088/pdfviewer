package com.seg3525_project.pdfviewer.models;

import java.util.ArrayList;

/**
 * Created by merek on 07/07/16.
 */
public class User {

    private String fullName;
    private String email;
    private String password;
    private ArrayList<Book> booksInCart;

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        booksInCart = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getBooksInCart() {
        return booksInCart;
    }

    public void setBooksInCart(ArrayList<Book> booksInCart) {
        this.booksInCart = booksInCart;
    }

    public boolean addBookToCart(Book book) {
        for(int i = 0; i < booksInCart.size(); i++) {
            if(booksInCart.get(i).equals(book))
                return false;
        }

        booksInCart.add(book);
        return true;

    }

    public void removeBookFromCart(Book book) {
        booksInCart.remove(book);
    }

}
