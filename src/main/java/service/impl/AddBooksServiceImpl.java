    package service.impl;

    import db.dbConnection;
    import model.dto.BookDTO;
    import repository.BookRepository;
    import service.AddBookService;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class AddBooksServiceImpl implements AddBookService {

        @Override
        public boolean addBooks(BookDTO bookDTO) {
            BookRepository bookRepository = new BookRepository();

            return bookRepository.addBook(bookDTO);
        }
    }
