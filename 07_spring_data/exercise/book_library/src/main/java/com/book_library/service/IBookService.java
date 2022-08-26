package com.book_library.service;

import com.book_library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllBook(String name, Pageable pageable);

    void borrowBook(Long id);

    Book findById(Long id);

    void giveBookBack(Long id);
}
