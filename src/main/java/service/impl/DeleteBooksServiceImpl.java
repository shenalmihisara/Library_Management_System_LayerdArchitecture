package service.impl;

import repository.BookRepository;
import service.DeleteBookService;

public class DeleteBooksServiceImpl implements DeleteBookService {

    BookRepository bookRepository = new BookRepository();

    @Override
    public boolean deleteBook(String bookName, Long bookId) {
        return bookRepository.deleteBook(bookName, bookId);
    }
}