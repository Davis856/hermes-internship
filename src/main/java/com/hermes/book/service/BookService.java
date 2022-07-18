package com.hermes.book.service;

import com.hermes.book.model.Book;
import com.hermes.book.model.DTO.BookDTO;
import com.hermes.book.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final IBookRepository repository;

    public void save(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getNumberOfPages());

        repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBook(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateBook(Long id, String newTitle)
    {
        repository.updateBookTitle(id, newTitle);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public void deleteBookByTitle(String title) {
        repository.deleteByTitle(title);
    }

}
