package com.sparta.gr.springcrudexample.service;

import com.sparta.gr.springcrudexample.entites.BookEntity;
import com.sparta.gr.springcrudexample.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public BookEntity findBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Book ID " + id)
        );
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
