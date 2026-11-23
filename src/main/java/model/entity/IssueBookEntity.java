package model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issuebooks")
public class IssueBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_book_id")
    private Long issuBookId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    public Long getIssuBookId() {
        return issuBookId;
    }

    public void setIssuBookId(Long issuBookId) {
        this.issuBookId = issuBookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public IssueBookEntity(Long issuBookId, String memberId, String bookId, LocalDate issueDate, LocalDate dueDate) {
        this.issuBookId = issuBookId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public IssueBookEntity() {
    }

    @Override
    public String toString() {
        return "IssueBookEntity{" +
                "issuBookId='" + issuBookId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
