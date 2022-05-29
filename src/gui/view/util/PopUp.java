package gui.view.util;

import javafx.scene.control.Alert;

public class PopUp {
    public static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Something went wrong...");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
