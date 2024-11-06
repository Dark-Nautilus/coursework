package petclinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import petclinic.view.SceneView;
import petclinic.dao.Database;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Database.createConnection();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("auth-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(800);
        stage.setMinHeight(800);

        stage.setTitle("Ветеринарная клиника");
        stage.setScene(scene);

        SceneView.init(stage, scene);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Database.closeConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
