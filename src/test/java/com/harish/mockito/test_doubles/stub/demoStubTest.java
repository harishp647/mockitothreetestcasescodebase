package com.harish.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class demoStubTest {


    @Test
    public void demoStub()
    {
        BookRepository stubBookRepository = new StubBookRepository();
        BookService bookService = new BookService(stubBookRepository);

        List<Book> newBookshavingdiscount = bookService.booksWithApplieddiscount(10,7);

        assertEquals(2,newBookshavingdiscount.size());
        assertEquals(450,newBookshavingdiscount.get(0).getPrice());
        assertEquals(360,newBookshavingdiscount.get(1).getPrice());

    }

    @Test
    public void demoStubWithMockito()
    {
        BookRepository stubBookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(stubBookRepository);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(stubBookRepository.findnewBooks(7)).thenReturn(newBooks);

        List<Book> newBookwithAppliedDiscount = bookService.booksWithApplieddiscount(10,7);
        assertEquals(2,newBookwithAppliedDiscount.size());
        assertEquals(450,newBookwithAppliedDiscount.get(0).getPrice());
        assertEquals(360,newBookwithAppliedDiscount.get(1).getPrice());

    }
}
