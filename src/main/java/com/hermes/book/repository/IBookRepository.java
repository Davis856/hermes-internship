package com.hermes.book.repository;

import com.hermes.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    void deleteByTitle(String title);

    @Modifying
    @Query("update Book book set book.title = :title where book.id = :id")
    void updateBookTitle(@Param(value="id") Long id, @Param(value="title") String newTitle);
}
