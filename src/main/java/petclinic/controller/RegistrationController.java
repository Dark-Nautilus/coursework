package petclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import petclinic.Client;
import petclinic.dao.UserDao;
import petclinic.model.User;
import petclinic.view.SceneView;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController {
    public TextField nameField;
    public TextField addressField;
    public TextField phoneField;
    public TextField loginField;
    public PasswordField passwordField;

    @FXML
    protected void backToLoginAction() throws IOException {
        SceneView.setScene("auth-view.fxml");
    }

    @FXML
    protected void registerAction() throws SQLException, IOException {
        UserDao userDAO = new UserDao();
        User user = new User(0, nameField.getText(), addressField.getText(), phoneField.getText(), loginField.getText(), passwordField.getText(), 0);
        userDAO.add(user);
        Client.setUser(user);
        SceneView.setScene("appointment-view.fxml");
    }
}
