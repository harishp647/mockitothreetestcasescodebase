package com.harish.mockito.test_doubles.annotation.support;


import com.harish.mockito.test_doubles.annotation.support.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoTestDemolishAnnotation {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void demoStubWithMockito() {

//        BookRepository stubBookRepository = Mockito.mock(BookRepository.class);
//        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book(1234, "MockitoInAction", 500, LocalDate.now());
        Book book2 = new Book(12345, "JUnit5InAction", 400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(bookRepository.findnewBooks(7)).thenReturn(newBooks);

        List<Book> newBookwithAppliedDiscount = bookService.booksWithApplieddiscount(10, 7);
        assertEquals(2, newBookwithAppliedDiscount.size());
        assertEquals(450, newBookwithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBookwithAppliedDiscount.get(1).getPrice());

    }
}
