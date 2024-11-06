package petclinic.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import petclinic.Client;
import petclinic.dao.AppointmentDao;
import petclinic.dao.OwnerDao;
import petclinic.dao.PetDao;
import petclinic.model.Appointment;
import petclinic.model.Owner;
import petclinic.model.Pet;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private TableView<Appointment> appointmentsTableView;

    @FXML
    public TableColumn<Appointment, Date> dateColumn;
    @FXML
    public TableColumn<Appointment, Time> timeColumn;
    @FXML
    public TableColumn<Appointment, String> petColumn;
    @FXML
    public TableColumn<Appointment, String> vetColumn;
    @FXML
    public TableColumn<Appointment, String> diagnosisColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        petColumn.setCellValueFactory(new PropertyValueFactory<>("petName"));
        vetColumn.setCellValueFactory(new PropertyValueFactory<>("vetName"));
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("disease"));
        OwnerDao ownerDAO = new OwnerDao();
        AppointmentDao appointmentDAO = new AppointmentDao();
        PetDao petDAO = new PetDao();
        try {
            Owner owner = ownerDAO.get(Client.getUserPhone());
            List<Pet> pets = petDAO.getByOwner(owner);
            ObservableList<Appointment> appointments = FXCollections.observableArrayList();
            for (Pet pet : pets) {
                List<Appointment> petAppointments = appointmentDAO.getByPet(pet);
                appointments.addAll(petAppointments);
            }
            appointmentsTableView.setItems(appointments);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
