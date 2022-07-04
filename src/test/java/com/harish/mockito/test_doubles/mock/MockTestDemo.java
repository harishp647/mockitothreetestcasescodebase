package com.harish.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class MockTestDemo {
    @Test
    public void DemoTest()
    {
       MockRepository mockRepo =  new MockRepository();
       BookService bookService = new BookService(mockRepo);

       Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
       Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

       bookService.addBook(book1);//return
       bookService.addBook(book2); // save will be called

       mockRepo.verify(book2,1);
    }

    @Test
    public void DemoMockitoWithSpy()
    {
        BookRepository mockRepo = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(mockRepo);

        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        bookService.addBook(book1);//return
        bookService.addBook(book2); // save will be called

        Mockito.verify(mockRepo).saveBook(book2);
        Mockito.verify(mockRepo,Mockito.times(1)).saveBook(book2);
      //  Mockito.verify(mockRepo).saveBook(book1); //return
        Mockito.verify(mockRepo,Mockito.times(0)).saveBook(book1);
    }
}
