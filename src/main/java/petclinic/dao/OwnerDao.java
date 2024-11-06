package petclinic.dao;

import petclinic.model.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerDao implements DataAccessObject<Owner> {
    private Connection connection;

    public OwnerDao() {
        this.connection = Database.getConnection();
    }

    // Methods for CRUD operations with Owner table
    @Override
    public void add(Owner entity) throws SQLException {
        String update = "INSERT INTO Owners (name, address, phone_number)" +
                        "VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getName());
        stmt.setString(2, entity.getAddress());
        stmt.setString(3, entity.getPhoneNumber());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public Owner get(int id) throws SQLException {
        String query = "SELECT * FROM Owners WHERE owner_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Owner owner = new Owner(
                    id,
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number"));
            stmt.close();
            resultSet.close();
            return owner;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    public Owner get(String phoneNumber) throws SQLException {
        String query = "SELECT * FROM Owners WHERE phone_number = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, phoneNumber);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Owner owner = new Owner(
                    resultSet.getInt("owner_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    phoneNumber);
            stmt.close();
            resultSet.close();
            return owner;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    @Override
    public void update(Owner entity) {

    }

    @Override
    public void delete(int id) {

    }
}
