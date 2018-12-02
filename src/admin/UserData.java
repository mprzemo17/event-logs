package admin;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {


    private final Integer id;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty profile;


    public UserData(Integer id, String username, String password, String profile){


        this.id = new Integer(id);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.profile = new SimpleStringProperty(profile);


    }

    public Integer getId() {
        return id;
    }

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
