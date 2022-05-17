package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double xoffset;
    private double yoffset;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../gui/view/loginView.fxml"));
        root.setOnMousePressed(event -> {
            xoffset = event.getSceneX();
            yoffset = event.getSceneY();

        });
        root.setOnMouseDragged(e->{
            primaryStage.setX(e.getSceneX()- xoffset);
            primaryStage.setY(e.getScreenY() - yoffset);
        });
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        scene.setFill(Color.TRANSPARENT);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
