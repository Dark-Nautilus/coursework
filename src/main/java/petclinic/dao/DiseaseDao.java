package petclinic.dao;

import petclinic.model.Disease;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiseaseDao implements DataAccessObject<Disease> {
    private Connection connection;

    public DiseaseDao() {
        this.connection = Database.getConnection();
    }

    @Override
    public void add(Disease entity) {

    }

    @Override
    public Disease get(int id) throws SQLException {
        String query = "SELECT * FROM Diseases WHERE disease_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Disease disease = new Disease(
                    resultSet.getInt("disease_id"),
                    resultSet.getString("common_name"),
                    resultSet.getString("scientific_name")
            );
            stmt.close();
            resultSet.close();

            return disease;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    @Override
    public void update(Disease entity) {

    }

    @Override
    public void delete(int id) {

    }
}
