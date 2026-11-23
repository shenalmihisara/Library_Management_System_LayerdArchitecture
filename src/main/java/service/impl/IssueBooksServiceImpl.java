package service.impl;

import db.dbConnection;
import model.dto.IssueBookDTO;
import repository.IssueBookRepository;
import service.IssueBookService;

import java.sql.*;

public class IssueBooksServiceImpl implements IssueBookService {

    IssueBookRepository issueBookRepository = new IssueBookRepository();

    @Override
    public Long getMemberIdFromDb(String memberName) {
        return issueBookRepository.getMemberIdFromDb(memberName);
    }

    @Override
    public Long getBookIdFromDb(String bookName) {
        return issueBookRepository.getBookIdFromDb(bookName);
    }

    @Override
    public boolean issueBooks(IssueBookDTO issueBookDTO) {
        return issueBookRepository.issueBooks(issueBookDTO);
    }
}
