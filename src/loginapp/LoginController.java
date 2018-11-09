package loginapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btn_signin, btn_signup;

    @FXML
        private AnchorPane pn_signin, pn_signup;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_signin)
        {
                pn_signin.toFront();
        }
        else
            if (event.getSource() == btn_signup)
            {
                pn_signup.toFront();
            }

    }


     @FXML
        public Button closeButton;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}