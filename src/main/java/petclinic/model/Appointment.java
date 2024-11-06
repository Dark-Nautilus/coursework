package petclinic.model;

import petclinic.dao.DiagnosisDao;
import petclinic.dao.DiseaseDao;
import petclinic.dao.PetDao;
import petclinic.dao.VetDao;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class Appointment {
    private int appointmentId;
    private Date date;
    private Time time;
    private int petId;
    private int vetId;
    private String petName;
    private String vetName;
    private Disease disease;

    public Appointment(int id, Date date, Time time, int petId, int vetId) throws SQLException {
        this.appointmentId = id;
        this.date = date;
        this.time = time;
        this.petId = petId;
        this.vetId = vetId;
        PetDao petDAO = new PetDao();
        this.petName = petDAO.get(petId).getName();
        VetDao vetDAO = new VetDao();
        this.vetName = vetDAO.get(vetId).getName();
        DiagnosisDao diagnosisDAO = new DiagnosisDao();
        DiseaseDao diseaseDAO = new DiseaseDao();
        Diagnosis diagnosis = diagnosisDAO.getByAppointmentId(id);
        this.disease = diseaseDAO.get(diagnosis.getDiseaseId());

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getPetId() {
        return petId;
    }

    public int getVetId() {
        return vetId;
    }

    public String getPetName() {
        return petName;
    }

    public String getVetName() {
        return vetName;
    }

    public String getDisease() {
        return disease.getCommonName();
    }
}
