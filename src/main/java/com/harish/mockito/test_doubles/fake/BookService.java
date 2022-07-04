package com.harish.mockito.test_doubles.fake;

import com.harish.mockito.test_doubles.dummy.EmailService;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book)
    {
      bookRepository.saveBook(book);
    }

    public Collection<Book> findAllofBooks()
    {
      return  bookRepository.findAll();
    }
}
