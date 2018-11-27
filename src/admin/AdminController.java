package admin;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    //przycisk Exit odpowiedzialny za zamknięcie okna logowania aplikacji! DZIAŁA!!!!!
    @FXML
    private void closeAction(ActionEvent exitButton) {
        System.exit(0);
    }

// KONIEC KODU OPDOWIEDZIALNEGO ZA ZAMKNIĘCIE APLIKACJI



    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField profile;
//    @FXML
//    private TextField ID;




    @FXML
    private TableView<UserData> usertable;


//    @FXML
//    private TableColumn<UserData, String> idcolumn;
    @FXML
    private TableColumn<UserData, String> usernamecolumn;
    @FXML
    private TableColumn<UserData, String> passwordcolumn;
    @FXML
    private TableColumn<UserData, String> profilecolumn;




    private dbConnection dc;
    private ObservableList<UserData> data;


    private String sql = "SELECT * FROM loginaccess";


    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();
    }

    @FXML
    private void loadUserData(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new UserData(rs.getString(1), rs.getString(2), rs.getString(3)));

            }

        } catch (SQLException e) {
            System.err.println("Error" + e);

        }



//        this.idcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.usernamecolumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.passwordcolumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.profilecolumn.setCellValueFactory(new PropertyValueFactory<>("profile"));


        this.usertable.setItems(null);
        this.usertable.setItems(this.data);


    }


    //dodanie danych do bazy

    @FXML
    private void addUser(ActionEvent event) {
        String sqlInsert = "INSERT INTO loginaccess(username,password,profile) VALUES (?,?,?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

//            stmt.setString(1, this.ID.getText());
            stmt.setString(1, this.username.getText());
            stmt.setString(2, this.password.getText());
            stmt.setString(3, this.profile.getText());





            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //czyszczenie formularza

    @FXML
    private void clearFields(ActionEvent event) {
//        this.ID.setText("");
        this.username.setText("");
        this.password.setText("");
        this.profile.setText("");



    }

    //usuwanie dane tylko z tableview a w bazie dalej są....
//
//    @FXML
//    private void deleteRowFromTable(ActionEvent event){
//
//        usertable.getItems().removeAll(usertable.getSelectionModel().getSelectedItem());
//
//
//    }


//    //usuwanie danych do bazy
//@FXML
//private void deleteUser(ActionEvent event)
//    {
//        try
//        {
//            Connection conn = dbConnection.getConnection();
//            UserData userData = (UserData) usertable.getSelectionModel().getSelectedItems();
//            PreparedStatement stmt = conn.prepareStatement("DELETE FROM loginaccess WHERE id =?");
//
//            stmt.setString(1, username.getId());
//            stmt.execute();
//            conn.close();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
