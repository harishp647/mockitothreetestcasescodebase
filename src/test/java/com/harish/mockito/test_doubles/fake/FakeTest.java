package com.harish.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FakeTest {
    @Test
    public void Faketest()
    {

        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2,bookService.findAllofBooks().size());
    }

    @Test
    public void testFakeWithMockito()
    {
      BookRepository bookRepository = Mockito.mock(BookRepository.class);
      BookService bookService =new BookService(bookRepository);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        Collection<Book> BookCollection = new ArrayList<>();

        BookCollection.add(book1);
        BookCollection.add(book2);

        Mockito.when(bookService.findAllofBooks()).thenReturn(BookCollection);

        assertEquals(2,bookService.findAllofBooks().size());

    }
}
