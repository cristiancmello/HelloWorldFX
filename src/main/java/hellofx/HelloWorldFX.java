package hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var javaVersion = System.getProperty("java.version");
        var javaFxVersion = System.getProperty("javafx.version");
        var label = new Label("Hello, JavaFX " + javaFxVersion + ", running on Java " + javaVersion);

        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}