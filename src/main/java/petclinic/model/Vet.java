package petclinic.model;

public class Vet {
    private int vetId;
    private String name;
    private String address;
    private String phoneNumber;

    public Vet(int id, String name, String address, String phoneNumber) {
        this.vetId = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getVetId() {
        return vetId;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
