package repository;

import db.HibernateUtill;
import model.dto.IssueBookDTO;
import model.entity.IssueBookEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IssueBookRepository {

    Session session = HibernateUtill.getSession();

    public Long getMemberIdFromDb(String memberName) {

        String HQL = "SELECT memberId FROM MemberEntity WHERE name = :name";

        return session.createQuery(HQL, Long.class)
                .setParameter("name", memberName)
                .uniqueResult();
    }

    public Long getBookIdFromDb(String bookName) {
        String HQL = "SELECT bookId FROM BookEntity WHERE bookName = :bookName";

        return session.createQuery(HQL, Long.class)
                .setParameter("bookName", bookName)
                .uniqueResult();
    }

    public boolean issueBooks(IssueBookDTO issueBookDTO) {

        Transaction transaction = session.beginTransaction();

        IssueBookEntity issueBook = new IssueBookEntity();

        issueBook.setIssuBookId(issueBookDTO.getIssuBookId());
        issueBook.setBookId(issueBookDTO.getBookId());
        issueBook.setMemberId(issueBookDTO.getMemberId());
        issueBook.setIssueDate(issueBookDTO.getIssueDate());
        issueBook.setDueDate(issueBookDTO.getDueDate());

        session.persist(issueBook);

        transaction.commit();

        return true;

    }
}
