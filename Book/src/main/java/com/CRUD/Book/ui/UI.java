package com.CRUD.Book.ui;

import com.CRUD.Book.service.Service;

import java.util.Scanner;

public class UI {

    private final Service serv;

    public UI(Service serv) {
        this.serv = serv;
    }

    public void printMenu() {
        System.out.println("1. Add user.");
        System.out.println("2. Update user.");
        System.out.println("3. Delete user.");
        System.out.println("4. Add book to a user.");
        System.out.println("5. Update a book.");
        System.out.println("6. Remove book from a user.");
        System.out.println("0. Exit");
    }

    public void startUI() {
        while (true) {
            printMenu();
            int option = -1;
            Scanner reader = new Scanner(System.in);
            option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1: {
                    addUserUI();
                    break;
                }
                case 2: {
                    updateUserUI();
                    break;
                }
                case 3: {
                    deleteUserUI();
                    break;
                }
                case 4: {
                    addBookUI();
                    break;
                }
                case 5: {
                    updateBookUI();
                    break;
                }
                case 6: {
                    deleteBookUI();
                    break;
                }
                case 0:
                    return;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    public void addUserUI() {
        Scanner reader = new Scanner(System.in);
        String name;
        int id;
        System.out.println("Type in the name of the user:");
        name = reader.nextLine();
        System.out.println("Type in the id of the user:");
        id = reader.nextInt();
        reader.nextLine();
        this.serv.addUser(id, name);
    }

    public void updateUserUI() {
        Scanner reader = new Scanner(System.in);
        String oldName;
        String newName;
        System.out.println("Type in the current name of the user:");
        oldName = reader.nextLine();
        System.out.println("Type in the new name of the user:");
        newName = reader.nextLine();
        this.serv.updateUser(oldName, newName);
    }

    public void deleteUserUI() {
        Scanner reader = new Scanner(System.in);
        String name;
        System.out.println("Type in the user name that you want to delete:");
        name = reader.nextLine();
        this.serv.deleteUser(name);
    }

    public void addBookUI() {
        Scanner reader = new Scanner(System.in);
        String name;
        int bookID;
        int id;
        System.out.println("Type in the name of the book that you want to add:");
        name = reader.nextLine();
        System.out.println("Type in the id of the book that you want to add:");
        bookID = reader.nextInt();
        reader.nextLine();
        System.out.println("Type in the id of the user you want to add the book to:");
        id = reader.nextInt();
        reader.nextLine();
        this.serv.addBook(name, bookID, id);
    }

    public void updateBookUI() {
        Scanner reader = new Scanner(System.in);
        String oldName;
        int id;
        String newName;
        System.out.println("Type in the current name of the book that you want to update:");
        oldName = reader.nextLine();
        System.out.println("Type in the new name of the book that you want to update:");
        newName = reader.nextLine();
        System.out.println("Type in the id of the user that you want to modify the book for:");
        id = reader.nextInt();
        reader.nextLine();
        this.serv.updateBook(oldName, id, newName);
    }

    public void deleteBookUI() {
        Scanner reader = new Scanner(System.in);
        String name;
        int id;
        System.out.println("Type in the name of the book that you want to delete:");
        name = reader.nextLine();
        System.out.println("Type in the id of the user that you want to delete the book from:");
        id = reader.nextInt();
        reader.nextLine();
        this.serv.deleteBook(name, id);
    }
}
