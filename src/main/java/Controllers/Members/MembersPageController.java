package Controllers.Members;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.MemberEntity;
import scean.SceanManager;
import service.MemberService;
import service.impl.MemberServiceImpl;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MembersPageController implements Initializable {

    MemberService memberService = new MemberServiceImpl();

    @FXML
    public TableView<MemberEntity>tblMembers;

    @FXML
    public TableColumn<MemberEntity, String> colMemberAddress;

    @FXML
    private TableColumn<MemberEntity, String>colMemberId;

    @FXML
    private TableColumn<MemberEntity, String>colMemberName;

    @FXML
    private TableColumn<MemberEntity, String>colMemberEmail;

    @FXML
    private TableColumn<MemberEntity, String>colMemberPhoneNum;

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
    public void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void loadMember(){
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colMemberName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMemberEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMemberPhoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colMemberAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        tblMembers.setItems(FXCollections.observableList(memberService.getAllMembers()));
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        loadMember();
    }

    public void btnAddMemberSidebarOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    public void btnDeleteBoooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }
}
