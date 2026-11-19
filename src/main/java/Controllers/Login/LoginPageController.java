package Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dto.LoginDTO;
import scean.SceanManager;
import service.LoginController;
import service.LoginService;

public class LoginPageController {

    LoginService service = new LoginController();

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUserName(txtUserName.getText());
        loginDTO.setPassword(txtPassword.getText());

        if (service.CheckUserNameAndPassword(loginDTO)) {
            SceanManager.switchPage("/view/Home/Home_Page.fxml");
        }else {
            SceanManager.switchPage("/view/Login/Login_error_page.fxml");

        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }
}
