package bobby.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import bobby.main.Bobby;

public class Main extends Application {
    private final Bobby bobby = new Bobby("data/tasks.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setWidth(700);
            stage.setMinWidth(500);
            fxmlLoader.<MainWindow>getController().setBobby(bobby);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}