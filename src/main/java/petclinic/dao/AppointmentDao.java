package petclinic.dao;

import petclinic.model.Appointment;
import petclinic.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao implements DataAccessObject<Appointment> {
    private Connection connection;

    public AppointmentDao() {
        this.connection = Database.getConnection();
    }

    @Override
    public void add(Appointment entity) throws SQLException {
        String update = "INSERT INTO Appointments (date, time, pet_id, vet_id)" +
                        "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getDate().toString());
        stmt.setString(2, entity.getTime().toString());
        stmt.setInt(3, entity.getPetId());
        stmt.setInt(4, entity.getVetId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public Appointment get(int id) throws SQLException {
        String query = "SELECT * FROM Appointments WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        Appointment appointment = new Appointment(
                id,
                resultSet.getDate("date"),
                resultSet.getTime("time"),
                resultSet.getInt("pet_id"),
                resultSet.getInt("vet_id"));
        stmt.close();
        resultSet.close();

        return appointment;
    }

    public List<Appointment> getByPet(Pet pet) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointments WHERE pet_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, pet.getPetId());
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            appointments.add(new Appointment(
                    resultSet.getInt("appointment_id"),
                    resultSet.getDate("date"),
                    resultSet.getTime("time"),
                    pet.getPetId(),
                    resultSet.getInt("vet_id")
            ));
        }
        resultSet.close();
        stmt.close();

        return appointments;
    }

    @Override
    public void update(Appointment entity) throws SQLException {
        String update = "UPDATE Appointments SET date = ?, time = ?, pet_id = ?, vet_id = ? WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setDate(1, entity.getDate());
        stmt.setTime(2, entity.getTime());
        stmt.setInt(3, entity.getPetId());
        stmt.setInt(4, entity.getVetId());
        stmt.setInt(7, entity.getAppointmentId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        String update = "DELETE FROM Appointments WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
