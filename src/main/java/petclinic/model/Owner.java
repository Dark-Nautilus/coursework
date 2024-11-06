package petclinic.model;

public class Owner {
    private int ownerId;
    private String name;
    private String address;
    private String phoneNumber;

    public Owner(int id, String name, String address, String phoneNumber) {
        this.ownerId = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getOwnerId() {
        return ownerId;
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
