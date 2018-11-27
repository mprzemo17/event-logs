package admin;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {


//    private final StringProperty ID;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty profile;


    public UserData(String username, String password, String profile){


//        this.ID = new SimpleStringProperty(ID);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.profile = new SimpleStringProperty(profile);


    }

//    public String getID() {
//        return ID.get();
//    }
//
//    public StringProperty IDProperty() {
//        return ID;
//    }
//
//    public void setID(String ID) {
//        this.ID.set(ID);
//    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getProfile() {
        return profile.get();
    }

    public StringProperty profileProperty() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile.set(profile);
    }




}
