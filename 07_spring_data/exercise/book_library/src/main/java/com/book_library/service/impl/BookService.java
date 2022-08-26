package com.book_library.service.impl;

import com.book_library.model.Book;
import com.book_library.repository.IBookRepository;
import com.book_library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllBook(String name, Pageable pageable) {
        return iBookRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void borrowBook(Long id) {
        iBookRepository.borrowBook(id);
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void giveBookBack(Long id) {
        iBookRepository.giveBookBack(id);
    }
}
