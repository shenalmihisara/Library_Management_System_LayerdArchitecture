package service;

import model.dto.BookDTO;

public interface AddBookService {
    boolean addBooks(BookDTO bookDTO);
}