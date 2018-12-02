package admin;

import dbUtil.dbConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import static loginapp.option.User;

public class AdminController implements Initializable {


    //przycisk Exit odpowiedzialny za zamknięcie okna logowania aplikacji! DZIAŁA!!!!!
    @FXML
    private void closeAction(ActionEvent exitButton) {
        System.exit(0);
    }

// KONIEC KODU OPDOWIEDZIALNEGO ZA ZAMKNIĘCIE APLIKACJI


    @FXML
    private TextField ID;


    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField profile;


    @FXML
    private TableView<UserData> usertable;


    @FXML
    private TableColumn<UserData, Integer> idcolumn;
    @FXML
    private TableColumn<UserData, String> usernamecolumn;
    @FXML
    private TableColumn<UserData, String> passwordcolumn;
    @FXML
    private TableColumn<UserData, String> profilecolumn;


    private dbConnection dc;
    private ObservableList<UserData> data;


    private String sql = "SELECT * FROM loginaccess";


    @FXML
    private void loadUserData(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new UserData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }

        } catch (SQLException e) {
            System.err.println("Error" + e);

        }


        this.idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.usernamecolumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.passwordcolumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.profilecolumn.setCellValueFactory(new PropertyValueFactory<>("profile"));


        this.usertable.setItems(null);
        this.usertable.setItems(this.data);


    }


    //dodanie danych do bazy

    @FXML
    private void addUser(ActionEvent event) {
        String sqlInsert = "INSERT INTO loginaccess(id,username,password,profile) VALUES(?,?,?,?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.ID.getText());
            stmt.setString(2, this.username.getText());
            stmt.setString(3, this.password.getText());
            stmt.setString(4, this.profile.getText());


            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //czyszczenie formularza

    @FXML
    private void clearFields(ActionEvent event) {
        this.ID.setText("");
        this.username.setText("");
        this.password.setText("");
        this.profile.setText("");


    }

//    usuwanie dane tylko z tableview a w bazie dalej są....

    @FXML
    private void deleteRowFromTable(ActionEvent event) {

        usertable.getItems().removeAll(usertable.getSelectionModel().getSelectedItem());


    }


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

    //------------------------------------------------------------------------------------------------------------
//    AWARIE TABELA FAILURES
//------------------------------------------------------------------------------------------------------------
    ObservableList<Failures> dataFailures = FXCollections.observableArrayList();

    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    @FXML
    TableView<Failures> failurestable;

    @FXML
    private TableColumn<?, ?> idFailures;

    @FXML
    private TableColumn<?, ?> dateFailures;

    @FXML
    private TableColumn<?, ?> timeFailures;

    @FXML
    private TableColumn<?, ?> durationFailures;

    @FXML
    private TableColumn<?, ?> detailsFailures;

    @FXML
    private TableColumn<?, ?> causesFailures;

    @FXML
    private TableColumn<?, ?> effectsFailures;

    @FXML
    private TableColumn<?, ?> commentsFailures;

    @FXML
    private TableColumn<?, ?> signatureFailures;


    @FXML
    TextField idFailuresBox;

    @FXML
    TextField dateFailuresBox;

    @FXML
    TextField timeFailuresBox;

    @FXML
    TextField durationFailuresBox;

    @FXML
    TextField detailsFailuresBox;

    @FXML
    TextField causesFailuresBox;

    @FXML
    TextField effectsFailuresBox;

    @FXML
    TextField commentsFailuresBox;

    @FXML
    TextField signatureFailuresBox;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();

        idFailures.setCellValueFactory(new PropertyValueFactory<>("idFailures")); //lp
        dateFailures.setCellValueFactory(new PropertyValueFactory<>("dateFailures")); //data powstania awarii
        timeFailures.setCellValueFactory(new PropertyValueFactory<>("timeFailures")); //godzina awarii
        detailsFailures.setCellValueFactory(new PropertyValueFactory<>("detailsFailures")); //sczegóły awarii
        durationFailures.setCellValueFactory(new PropertyValueFactory<>("durationFailures")); //czas trwania
        causesFailures.setCellValueFactory(new PropertyValueFactory<>("causesFailures")); //przyczyny
        effectsFailures.setCellValueFactory(new PropertyValueFactory<>("effectsFailures")); //skutki
        commentsFailures.setCellValueFactory(new PropertyValueFactory<>("commentsFailures")); //uwagi
        signatureFailures.setCellValueFactory(new PropertyValueFactory<>("signatureFailures")); //podpis

        //   loadDatabaseDataFailures();
    }


    //-------------------------------------------------------ŁADOWANIE BAZY DANYCH DO TABLEVIEW TZN REFRESH DB
    private ObservableList<Failures> failures; //+


    String sql2 = "select * from failures";


    @FXML
    private void loadDatabaseDataFailures(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getConnection();
            this.failures = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql2);
            while (rs.next()) {
                this.failures.add(new Failures(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

            }

        } catch (SQLException e) {
            System.err.println("Error" + e);

        }

        this.idFailures.setCellValueFactory((new PropertyValueFactory<>("idFailures")));
        this.dateFailures.setCellValueFactory((new PropertyValueFactory<>("dateFailures")));
        this.timeFailures.setCellValueFactory((new PropertyValueFactory<>("timeFailures")));
        this.detailsFailures.setCellValueFactory((new PropertyValueFactory<>("detailsFailures")));
        this.durationFailures.setCellValueFactory((new PropertyValueFactory<>("durationFailures")));
        this.causesFailures.setCellValueFactory((new PropertyValueFactory<>("causesFailures")));
        this.effectsFailures.setCellValueFactory((new PropertyValueFactory<>("effectsFailures")));
        this.commentsFailures.setCellValueFactory((new PropertyValueFactory<>("commentsFailures")));
        this.signatureFailures.setCellValueFactory((new PropertyValueFactory<>("signatureFailures")));


        this.failurestable.setItems(null);
        this.failurestable.setItems(this.failures);

    }
    //--------------------------------------------------------------------- ŁADOWANIE BAZY DANYCH DO TABLEVIEW TZN REFRESH DB

    //      dodanie danych do bazy

    @FXML
    private void addFailures(ActionEvent event) {
        String sqlInsert2 = "INSERT INTO failures(idFailures,dateFailures,timeFailures,detailsFailures,durationFailures,causesFailures,effectsFailures,commentsFailures,signatureFailures) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt2 = conn.prepareStatement(sqlInsert2);

            stmt2.setString(1, this.idFailures.getText());
            stmt2.setString(2, this.dateFailures.getText());
            stmt2.setString(3, this.timeFailures.getText());
            stmt2.setString(4, this.detailsFailures.getText());
            stmt2.setString(5, this.durationFailures.getText());
            stmt2.setString(6, this.causesFailures.getText());
            stmt2.setString(7, this.effectsFailures.getText());
            stmt2.setString(8, this.commentsFailures.getText());
            stmt2.setString(9, this.signatureFailures.getText());


            stmt2.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}















