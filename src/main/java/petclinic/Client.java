package petclinic;

import petclinic.model.User;

public class Client {
    private static User user;

    public static void setUser(User user) {
        Client.user = user;
    }
    public static String getUserPhone() {
        return user.getPhoneNumber();
    }

}
