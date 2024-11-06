package petclinic.model;

public class Disease {
    private int diseaseId;
    private String commonName;
    private String scientificName;

    public Disease(int diseaseId, String commonName, String scientificName) {
        this.diseaseId = diseaseId;
        this.commonName = commonName;
        this.scientificName = scientificName;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }
}
