package loginapp;

import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import users.UsersController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private Button btn_signin, btn_signup;

    @FXML
    private AnchorPane pn_signin, pn_signup;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_signin) {
            pn_signin.toFront();
        } else if (event.getSource() == btn_signup) {
            pn_signup.toFront();
        }

    }


    LoginModel loginModel = new LoginModel();


    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button btn2_signin;

    @FXML
    private Label loginStatus;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Connected");
        } else {
            this.dbstatus.setText("Not Connected To Database");
        }
        this.combobox.setItems(FXCollections.observableArrayList(option.values()));

    }

    //login function

    @FXML
    public void Login(ActionEvent event) {
        try {

            if (this.loginModel.isLogin(this.username.getText(), this.password.getText(), ((option) this.combobox.getValue()).toString())) {
                Stage stage = (Stage) this.btn2_signin.getScene().getWindow();
                stage.close();
                switch (((option) this.combobox.getValue()).toString()) {
                    case "Admin":
                        adminLogin();
                        break;
                    case "User":
                        userLogin();
                        break;
                }
            } else {
                this.loginStatus.setText("Wrong Creditentials");

            }


        } catch (Exception localException) {

        }
    }

    public void userLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/users/usersFXML.fxml").openStream());

            UsersController usersController = (UsersController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("User Dashboard");
            userStage.setResizable(false);
            userStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void adminLogin() {

        try {
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
                         Pane adminroot = (Pane) adminLoader.load(getClass().getResource("/admin/adminFXML.fxml").openStream());

            AdminController adminController = (AdminController) adminLoader.getController();

            Scene scene = new Scene(adminroot);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(false);
            adminStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

