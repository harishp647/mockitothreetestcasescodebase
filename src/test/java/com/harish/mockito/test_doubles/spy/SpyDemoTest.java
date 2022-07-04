package com.harish.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class SpyDemoTest {
    @Test
    public void DemoSpy() {
        BookSpyRepository bookSpyRepository = new BookSpyRepository();
        BookService bookService = new BookService(bookSpyRepository);

        Book book1 = new Book(1234, "MockitoInAction", 500, LocalDate.now());
        Book book2 = new Book(12345, "JUnit5InAction", 300, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(1, bookSpyRepository.timesCalled());
        assertTrue(bookSpyRepository.lastSavedbook.equals(book2));
    }

    @Test
    public void DemoSpyWithMockito()
    {
        BookRepository bookSpyRepository = spy(BookRepository.class);
        BookService bookService = new BookService(bookSpyRepository);

        Book book1 = new Book(1234, "MockitoInAction", 500, LocalDate.now());
        Book book2 = new Book(12345, "JUnit5InAction", 300, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookSpyRepository,Mockito.times(1)).saveBook(book2);
        Mockito.verify(bookSpyRepository,Mockito.times(0)).saveBook(book1);
    }

}