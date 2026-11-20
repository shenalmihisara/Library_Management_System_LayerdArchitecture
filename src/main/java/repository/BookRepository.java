package repository;

import db.HibernateUtill;
import model.dto.BookDTO;
import model.entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepository {

    Session session = HibernateUtill.getSession();

    public boolean addBook(BookDTO bookDTO) {

        BookEntity bookEntity = new BookEntity();

        Transaction transaction = session.beginTransaction();

        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setRate(bookDTO.getRate());
        bookEntity.setBookType(bookDTO.getBookTytpe());

        session.persist(bookEntity);
        transaction.commit();

        return true;
    }
}
