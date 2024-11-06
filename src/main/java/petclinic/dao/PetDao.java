package petclinic.dao;

import petclinic.model.Owner;
import petclinic.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDao implements DataAccessObject<Pet> {
    private Connection connection;

    public PetDao() {
        this.connection = Database.getConnection();
    }

    public List<Pet> getByOwner(Owner owner) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM Pets WHERE owner_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, owner.getOwnerId());
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("pet_id");
            String name = resultSet.getString("name");
            int ownerId = resultSet.getInt("owner_id");
            int breedId = resultSet.getInt("breed_id");
            pets.add(new Pet(id, name, ownerId, breedId));
        }

        resultSet.close();
        stmt.close();

        return pets;
    }

    @Override
    public void add(Pet entity) {

    }

    @Override
    public Pet get(int id) throws SQLException {
        String query = "SELECT * FROM Pets WHERE pet_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Pet pet = new Pet(
                    resultSet.getInt("pet_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("owner_id"),
                    resultSet.getInt("breed_id"));
            stmt.close();
            resultSet.close();
            return pet;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    @Override
    public void update(Pet entity) {

    }

    @Override
    public void delete(int id) {

    }
}
