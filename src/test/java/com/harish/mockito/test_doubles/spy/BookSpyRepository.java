package com.harish.mockito.test_doubles.spy;

import java.util.Collection;

public class BookSpyRepository implements BookRepository {

    int saveCalled = 0;
    Book lastSavedbook = null;
    @Override
    public void saveBook(Book book) {
        saveCalled++;
        lastSavedbook = book;
    }

    public boolean lastSavedBook(Book book)
    {
       return lastSavedbook.equals(book);
    }

    public int timesCalled()
    {
        return saveCalled++;
    }

}
