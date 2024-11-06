package petclinic.dao;

import petclinic.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DataAccessObject<User> {
    private Connection connection;

    public UserDao() {
        this.connection = Database.getConnection();
    }

    @Override
    public void add(User entity) throws SQLException {
        String update = "INSERT INTO Users (login, name, address, phone_number, password, access_level)" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getLogin());
        stmt.setString(2, entity.getName());
        stmt.setString(3, entity.getAddress());
        stmt.setString(4, entity.getPhoneNumber());
        stmt.setString(5, entity.getPassword());
        stmt.setInt(6, entity.getAccessLevel());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public User get(int id) throws SQLException {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        User user = new User(
                id,
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone_number"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getInt("access_level"));
        stmt.close();
        resultSet.close();

        return user;
    }

    public User get(String login, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE login = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, login);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next() && password.equals(resultSet.getString("password"))) {
            User user = new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number"),
                    login,
                    resultSet.getString("password"),
                    resultSet.getInt("access_level"));
            stmt.close();
            resultSet.close();
            return user;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    @Override
    public void update(User entity) throws SQLException {
        String update = "UPDATE Users SET login = ?, name = ?, address = ?, phone_number = ?, password = ?, access_level = ? WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getLogin());
        stmt.setString(2, entity.getName());
        stmt.setString(3, entity.getAddress());
        stmt.setString(4, entity.getPhoneNumber());
        stmt.setString(5, entity.getPassword());
        stmt.setInt(6, entity.getAccessLevel());
        stmt.setInt(7, entity.getUserId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        String update = "DELETE FROM Users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
