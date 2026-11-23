package Controllers.Books;

import Controllers.Alert.AlertUtill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.dto.IssueBookDTO;
import scean.SceanManager;
import service.impl.IssueBooksServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueBooksPageController implements Initializable {

    IssueBooksServiceImpl issueBooksService = new IssueBooksServiceImpl();

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnCancle;

    @FXML
    private Button btnDeleteBooks;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    private DatePicker dateDue;

    @FXML
    private DatePicker dateIssue;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

//    @FXML
//    public TextField txtIssueBookId;

    @FXML
    void btnAddBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnDeleteBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    @FXML
    void btnDeleteMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Home/Home_Page.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

        IssueBookDTO issueBookDTO = new IssueBookDTO();

        issueBookDTO.setMemberId(txtMemberId.getText());
        issueBookDTO.setBookId(txtBookId.getText());
        issueBookDTO.setIssueDate(dateIssue.getValue());
        issueBookDTO.setDueDate(dateDue.getValue());

        boolean IsAdded = issueBooksService.issueBooks(issueBookDTO);

        if (IsAdded){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "Sucess",
                    "Sucessfully isssue book");
        } else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "ERROR",
                    "Faild To issue Book");
        }

        txtMemberId.clear();
        txtBookId.clear();
        txtBookName.clear();
        txtMemberName.clear();
        dateIssue.setValue(null);
        dateDue.setValue(null);
    }


    public void btnGetMemberIdOnAction(ActionEvent actionEvent) {
        Long memberIdFromDb = issueBooksService.getMemberIdFromDb(txtMemberName.getText());

        if (memberIdFromDb != null){
            txtMemberId.setText(String.valueOf(memberIdFromDb));
        }else {
            txtMemberId.clear();
            AlertUtill.showAlert(Alert.AlertType.ERROR,"Error","cannot find member Id");
        }
    }

    public void btnGetBookIdOnAction(ActionEvent actionEvent) {
        Long bookIdFromDb = issueBooksService.getBookIdFromDb(txtBookName.getText());

        if (bookIdFromDb != null){
            txtBookId.setText(String.valueOf(bookIdFromDb));
        }else {
            txtBookId.clear();
            AlertUtill.showAlert(Alert.AlertType.ERROR,"Error", "cannot find book Id");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtMemberId.setEditable(false);

//        IssueBookEntity issueBookEntity = new IssueBookEntity();
//        txtIssueBookId.setText("Your Issue Book Id Is : " + issueBookEntity.getIssuBookId());
    }
}
