package service;

import model.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> getAllBooks();
}
