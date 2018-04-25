package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IdUser;

    private String firstName;

    private String lastName;

    private String email;

    private String biography;

    private String pathToProfilePicture;

    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getIdUser() {
        return IdUser;
    }

    public void setIdUser(Integer id) {
        this.IdUser = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPathToProfilePicture() {
        return pathToProfilePicture;
    }

    public void setPathToProfilePicture(String pathToProfilePicture) {
        this.pathToProfilePicture = pathToProfilePicture;
    }
}
