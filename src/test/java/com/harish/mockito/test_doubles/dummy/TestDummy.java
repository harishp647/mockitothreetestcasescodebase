package com.harish.mockito.test_doubles.dummy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDummy {

    @Test
    public void DummyTest()
    {
        BookRepository dummyBookRepository = new DummyBookRepository();
        EmailService emailservice = new DummyEmailService();

        BookService bookService = new BookService(dummyBookRepository,emailservice);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2  = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        dummyBookRepository.saveBook(book1);
        dummyBookRepository.saveBook(book2);

        assertEquals(2,bookService.findAllofBooks().size());

    }

    @Test
    public void testDummyWithMock()
    {
        BookRepository dummyBookRepo = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);

        BookService bookService = new BookService(dummyBookRepo,emailService);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2  = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        Collection<Book> BookStore = new ArrayList<>();

        BookStore.add(book1);
        BookStore.add(book2);

        Mockito.when(bookService.findAllofBooks()).thenReturn(BookStore);
        assertEquals(2,bookService.findAllofBooks().size());
    }
}
