package com.harish.mockito.test_doubles.annotation.support;

import java.util.List;

public interface BookRepository {

    List<Book> findnewBooks(int days);
}
