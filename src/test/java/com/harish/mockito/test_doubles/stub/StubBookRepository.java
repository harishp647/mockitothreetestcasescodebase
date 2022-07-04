package com.harish.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubBookRepository implements BookRepository {
    @Override
    public List<Book> findnewBooks(int days) {
        Book book1 = new Book(1234,"MockitoInAction",500, LocalDate.now());
        Book book2 = new Book(12345,"JUnit5InAction",400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}
