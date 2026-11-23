package repository;

import db.HibernateUtill;
import model.dto.BookDTO;
import model.entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {

    Session session = HibernateUtill.getSession();
    BookEntity bookEntity = new BookEntity();

    public boolean addBook(BookDTO bookDTO) {

        Transaction transaction = session.beginTransaction();

        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setRate(bookDTO.getRate());
        bookEntity.setBookType(bookDTO.getBookTytpe());

        session.persist(bookEntity);
        transaction.commit();

        return true;
    }

    public List<BookEntity> getAllBooks() {
        String HQL = "FROM BookEntity";

        List<BookEntity> list = session.createQuery(HQL, BookEntity.class).list();

        return list;

    }

    public boolean deleteBook(String bookName, Long bookId) {
        Transaction transaction = session.beginTransaction();

        BookEntity book = session.find(BookEntity.class, bookId);

        if (book != null && bookId.equals(book.getBookId()) && bookName.equals(book.getBookName()) ){
            session.remove(book);
            transaction.commit();
            return true;
        }

        transaction.rollback();
        return false;
    }
}