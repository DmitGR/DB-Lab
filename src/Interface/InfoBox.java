package Interface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by SmiLeX on 26.11.2017.
 */
public final class InfoBox
{
    static void display(String title, String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMaxHeight(125);
        window.setMinHeight(125);
        window.setMaxWidth(250);
        window.setMinWidth(250);
        window.setAlwaysOnTop(true);
        Label text = new Label();
        text.setAlignment(Pos.CENTER);
        text.setWrapText(true);
        text.setMaxSize(200,115);
        Button button = new Button();
        button.setOnAction(e -> window.close());
        button.setText("Ok");
        VBox layout = new VBox(20);
        layout.getChildren().addAll(text, button);
        layout.setAlignment(Pos.CENTER);
        text.setText(message);
        window.setTitle(title);
        window.setScene(new Scene(layout));
        window.showAndWait();
    }
}
