package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class ClickableButtonTests {
    private Button button;

    @Start
    void start(Stage stage) {
        button = new Button("click me!");
        button.setId("myButton");
        button.setOnAction(actionEvent -> button.setText("clicked!"));
        stage.setScene(new Scene(new StackPane(button), 100, 100));
        stage.show();
    }

    @Test
    void should_contain_button_with_text(FxRobot robot) {
        assertThat(button.getText()).isEqualTo("click me!");
        assertThat(robot.lookup("#myButton").queryAs(Button.class).getText()).isEqualTo("click me!");
        assertThat(robot.lookup(".button").queryAs(Button.class).getText()).isEqualTo("click me!");
        assertThat(robot.lookup(".button").queryButton().getText()).isEqualTo("click me!");
    }

    @Test
    void when_button_is_clicked_text_changed(FxRobot robot) {
        // when
        robot.clickOn(".button");

        // then
        assertThat(button.getText()).isEqualTo("clicked!");
    }
}
