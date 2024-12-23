package com.example.softwareengineeringprototype3.production;

import java.util.Random;

public class User {

    private int userID = -1;
    private String name = "";
    private String organisation = "N/A";
    private boolean camera = false;
    private boolean microPhone = false;

    //chosen user ID, for testing
    public User(int userID, String name, String organisation) {
        this.userID = userID;
        this.name = name;
        this.organisation = organisation;
    }

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    //random user ID
    public User(String name, String organisation) {
        Random random = new Random();
        userID = random.nextInt(10000);
        this.name = name;
        this.organisation = organisation;
    }

    public User(String name) {
        Random random = new Random();
        userID = random.nextInt(10000);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getOrganisation() {
        return organisation;
    }

    public boolean isCameraOn() {
        return camera;
    }

    public boolean isMicroPhoneOn() {
        return microPhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public void setMicroPhone(boolean microPhone) {
        this.microPhone = microPhone;
    }
}
