package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage=primaryStage;
        primaryStage.setMinWidth(940);
        primaryStage.setMaxWidth(960);
        primaryStage.setMinHeight(640);
        primaryStage.setMaxWidth(660);
        primaryStage.setTitle("Students List");
        primaryStage.setScene(new Scene(root, 920, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
