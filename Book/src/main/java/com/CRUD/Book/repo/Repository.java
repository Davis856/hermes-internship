package com.CRUD.Book.repo;

import com.CRUD.Book.domain.Book;
import com.CRUD.Book.domain.User;

import java.util.Vector;

public class Repository {

    private final Vector<User> users = new Vector<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public void updateUser(String newName, User oldUser) {
        if (oldUser != null)
            oldUser.setName(newName);
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addBook(Book book, int id) {
        this.users.get(id).getBooks().add(book);
    }

    public void updateBook(int bookID, int userID, String newName) {
        this.users.get(userID).getBooks().get(bookID).setName(newName);
    }

    public void deleteBook(Book book, int id) {
        this.users.get(id).getBooks().remove(book);
    }

    public Vector<User> getAll() {
        return this.users;
    }
}
