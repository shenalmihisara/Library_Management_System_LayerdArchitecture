package service;

import model.dto.IssueBookDTO;

public interface IssueBookService {

    Long getMemberIdFromDb(String memberName);

    Long getBookIdFromDb(String bookName);

    boolean issueBooks(IssueBookDTO issueBookDTO);
}
