package com.hermes.book.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private int numberOfPages;
}
