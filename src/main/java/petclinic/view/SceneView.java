package petclinic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import petclinic.Main;

import java.io.IOException;

public class SceneView {
    private static Stage stage;
    private static Scene scene;

    public static void init(Stage stage, Scene scene) {
        SceneView.stage = stage;
        SceneView.scene = scene;
        stage.show();
    }

    public static void setScene(String sceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(sceneName));
        double width = stage.getWidth(), height = stage.getHeight();
        SceneView.scene = new Scene(fxmlLoader.load());
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setScene(scene);
        stage.show();
    }
}
