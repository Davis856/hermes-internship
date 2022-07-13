package com.CRUD.Book.service;

import com.CRUD.Book.domain.Book;
import com.CRUD.Book.domain.User;
import com.CRUD.Book.repo.Repository;

import java.util.Vector;

public class Service {
    private Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public void addUser(int id, String name) {
        User user = new User(id, name);
        this.repo.addUser(user);
    }

    public void updateUser(String oldName, String newName) {
        User oldUser = findUserByName(oldName);
        if (oldUser != null)
            this.repo.updateUser(newName, oldUser);
    }

    public void deleteUser(String name) {
        User user = findUserByName(name);
        if (user != null)
            this.repo.deleteUser(user);
    }

    public void addBook(String name, int bookID, int id) {
        Book book = new Book(bookID, name);
        this.repo.addBook(book, id);
    }

    public void updateBook(String oldName, int id, String newName) {
        Book book = findBookByName(oldName, id);
        if (book != null)
            this.repo.updateBook(book.getId(), id, newName);
    }

    public void deleteBook(String name, int id) {
        Book book = findBookByName(name, id);
        if (book != null)
            this.repo.deleteBook(book, id);
    }

    public Book findBookByName(String name, int id) {
        User user = findUserByID(id);
        for (Book book : user.getBooks()) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public int findUserPosByName(String name) {
        Vector<User> users = this.repo.getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public int findUserPosByID(int id) {
        Vector<User> users = this.repo.getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public User findUserByID(int id) {
        Vector<User> users = this.repo.getAll();
        for (User user : users)
            if (user.getId() == id)
                return user;
        return null;
    }

    public User findUserByName(String name) {
        Vector<User> users = this.repo.getAll();
        for (User user : users)
            if (user.getName().equals(name))
                return user;
        return null;
    }
}
