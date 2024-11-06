package petclinic.dao;

import petclinic.model.Diagnosis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisDao implements DataAccessObject<Diagnosis> {
    private Connection connection;

    public DiagnosisDao() {
        this.connection = Database.getConnection();
    }

    @Override
    public void add(Diagnosis entity) {

    }

    @Override
    public Diagnosis get(int id) {
        return null;
    }

    @Override
    public void update(Diagnosis entity) {

    }

    @Override
    public void delete(int id) {

    }

    public Diagnosis getByAppointmentId(int appointmentId) throws SQLException {
        String query = "SELECT * FROM Diagnoses WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, appointmentId);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Diagnosis diagnosis = new Diagnosis(
                    resultSet.getInt("diagnosis_id"),
                    resultSet.getInt("disease_id"),
                    resultSet.getInt("appointment_id")
            );
//            System.out.println(1);
            stmt.close();
            resultSet.close();

            return diagnosis;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }
}
