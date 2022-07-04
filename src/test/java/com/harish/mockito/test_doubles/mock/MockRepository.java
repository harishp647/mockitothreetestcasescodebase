package com.harish.mockito.test_doubles.mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockRepository implements BookRepository{

    int saveCalled = 0;
    Book lastSavedBook = null;

    @Override
    public void saveBook(Book book) {
        saveCalled++;
        lastSavedBook = book;
    }

    public void verify(Book book, int timesCalled)
    {
       assertEquals(timesCalled,saveCalled);
       assertEquals(book,lastSavedBook);
    }
}
