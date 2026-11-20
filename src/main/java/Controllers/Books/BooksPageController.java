package Controllers.Books;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.BookEntity;
import scean.SceanManager;
import service.BookService;
import service.impl.BookServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class BooksPageController implements Initializable {

    BookService bookService = new BookServiceImpl();

    @FXML
    public TableView<BookEntity>tableBooks;

    @FXML
    public TableColumn<BookEntity, Long>colBookId;

    @FXML
    public TableColumn<BookEntity, String>colBookName;

    @FXML
    public TableColumn<BookEntity, String>colBookAuthor;

    @FXML
    public TableColumn<BookEntity, String>colRate;

    @FXML
    public TableColumn<BookEntity, String>colBookCategory;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
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

    public void btnReturnBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }

    public void btnIssueBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnAddMemberSidebarOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    public void btnDeleteBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    public void loadBook(){
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        colRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        colBookCategory.setCellValueFactory(new PropertyValueFactory<>("bookType"));

        tableBooks.setItems(FXCollections.observableList(bookService.getAllBooks()));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBook();
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    public void btnIssueBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnReturmBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }
}
