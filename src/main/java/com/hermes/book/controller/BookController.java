package com.hermes.book.controller;

import com.hermes.book.model.Book;
import com.hermes.book.model.DTO.BookDTO;
import com.hermes.book.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @ApiOperation(
            value = "Retrieves all books",
            response = List.class
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "All good", response = List.class),
                    @ApiResponse(code = 204, message = "No book found")
            }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = service.getBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @ApiOperation(
            value = "Retrieve a book by ID",
            response = Book.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Here you go", response = Book.class),
            @ApiResponse(code = 404, message = "No book with that ID")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable Long id) {
        Book book = service.getBook(id);
        if (book == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(book);
    }

    @ApiOperation(
            value = "Add a book to the database"
    )
    @ApiResponse(code = 200, message = "Book added successfully")
    @GetMapping("/save")
    public ResponseEntity<Void> save(BookDTO dto) {
        service.save(dto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "Update a book from the database"
    )
    @ApiResponse(code = 200, message = "Updated successfully")
    @GetMapping("/update")
    @Transactional
    public ResponseEntity<Void> update(BookDTO dto, String newName) {
        service.updateBook(dto.getId(), newName);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "Delete a book from the database"
    )
    @ApiResponse(code = 200, message = "Deleted successfully")
    @GetMapping("/delete")
    @Transactional
    public ResponseEntity<Void> delete(BookDTO dto) {
        service.deleteBookByTitle(dto.getTitle());
        return ResponseEntity.ok().build();
    }
}
