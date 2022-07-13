package com.CRUD.Book.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Vector;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String name;

    private Vector<Book> books;

    public User(int userID, String name) {
        this.id = userID;
        this.name = name;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
