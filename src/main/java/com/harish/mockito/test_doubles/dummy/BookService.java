package com.harish.mockito.test_doubles.dummy;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;
    private EmailService emailService;

    public BookService(BookRepository bookRepository, EmailService emailservice) {
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

    public void mailService()
    {
        String message = "Hello World";
        emailService.sendEmail(message);
    }
}
