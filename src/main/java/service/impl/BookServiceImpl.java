package service.impl;

import model.entity.BookEntity;
import repository.BookRepository;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    public List<BookEntity> getAllBooks(){

        BookRepository bookRepository = new BookRepository();

        return bookRepository.getAllBooks();
    }
}
