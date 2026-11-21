package service.impl;

import db.dbConnection;
import repository.BookRepository;
import service.DeleteBookService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBooksServiceImpl implements DeleteBookService {

    BookRepository bookRepository = new BookRepository();

    @Override
    public boolean deleteBook(String bookName, Long bookId) {
        return bookRepository.deleteBook(bookName, bookId);
    }
}