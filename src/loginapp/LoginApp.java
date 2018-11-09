package loginapp;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;



public class LoginApp extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public void start (Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));
       // stage.initStyle(StageStyle.TRANSPARENT);  //odpowiada za to aby nie było w gui ramki z zamknięciem i minimalizacją (obramowanie)




        //kod odpowiadający za przejścia ramek

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getSceneY() - yOffset);
            }
        });




        Scene scene = new Scene(root);

       // set transparent
        //scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.setTitle("Event Logs");
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }


}
