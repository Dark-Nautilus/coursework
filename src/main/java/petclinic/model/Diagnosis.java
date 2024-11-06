package petclinic.model;

public class Diagnosis {
    private int diagnosisId;
    private int diseaseId;
    private int appointmentId;

    public Diagnosis(int diagnosisId, int diseaseId, int appointmentId) {
        this.diagnosisId = diagnosisId;
        this.diseaseId = diseaseId;
        this.appointmentId = appointmentId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }
}
