package petclinic.model;

public class User {
    private int userId;
    private String name;
    private String address;
    private String phoneNumber;
    private String login;
    private String password;
    private int accessLevel;



    public User(int id, String name, String address, String phoneNumber, String login, String password, int accessLevel) {
        this.userId = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
    public int getUserId() {
        return userId;
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
