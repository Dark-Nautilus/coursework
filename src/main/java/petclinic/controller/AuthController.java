package petclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import petclinic.Client;
import petclinic.dao.UserDao;
import petclinic.model.User;
import petclinic.view.SceneView;

import java.io.IOException;
import java.sql.SQLException;

public class AuthController {
    public TextField loginField;
    public PasswordField passwordField;
    public Label incorrectInputLabel;

    @FXML
    protected void registerAction() throws IOException {
        SceneView.setScene("registration-view.fxml");
    }

    @FXML
    public void loginAction() throws Exception {
        UserDao userDAO = new UserDao();
        try {
            User user = userDAO.get(loginField.getText(), passwordField.getText());
            Client.setUser(user);
            SceneView.setScene("appointment-view.fxml");
        }
        catch (SQLException e) {
            e.printStackTrace();
            incorrectInputLabel.setVisible(true);
        }
    }
}
