package com.example.softwareengineeringprototype3.production;

import java.util.ArrayList;

public class VoiceCall {
    private boolean cameraPermissions = false;
    private boolean microphonePermissions = false;
    private boolean microphone = true;
    private boolean camera = true;
    private boolean organisationPermissions = true;
    private ArrayList<String> permittedOrganisations = new ArrayList<>();
    private boolean userPermissions = true;
    private ArrayList<Integer> userIDs = new ArrayList<>();

    public boolean permissionToJoinVoiceCall(User user) {

        if (userPermissions && userIDs.contains(user.getUserID()))
            return true;

        if (organisationPermissions && !permittedOrganisations.contains(user.getOrganisation()))
            return false;

        //set microphone and camera if applicable
        if (cameraPermissions)
            user.setCamera(camera);

        if (microphonePermissions)
            user.setMicroPhone(microphone);

        return !userPermissions;
    }

    public boolean addUserID(int userID) {
        if (!userIDs.contains(userID)) {
            userIDs.add(userID);
            return true;
        }
        return false;
    }

    public boolean addOrganisation(String organisation) {
        if (!permittedOrganisations.contains(organisation)) {
            permittedOrganisations.add(organisation);
            return true;
        }
        return false;
    }

    public boolean deleteUserID(int userID) {
        if (userIDs.contains(userID)) {
            userIDs.remove(userIDs.indexOf(userID));
            return true;
        }
        return false;
    }

    public boolean deleteOrganisation(String organisation) {
        if (permittedOrganisations.contains(organisation)) {
            permittedOrganisations.remove(organisation);
            return true;
        }
        return false;
    }

    public void clearUserIDs() {
        userIDs.clear();
    }

    public void clearOrganisations() {
        permittedOrganisations.clear();
    }

    ////////////////////////////////////////////////////////
    public ArrayList<Integer> getUserIDs() {
        return userIDs;
    }

    public ArrayList<String> getPermittedOrganisations() {
        return permittedOrganisations;
    }

    public boolean isCamera() {
        return camera;
    }

    public boolean isCameraPermissions() {
        return cameraPermissions;
    }

    public boolean isMicrophone() {
        return microphone;
    }

    public boolean isMicrophonePermissions() {
        return microphonePermissions;
    }

    public boolean isOrganisationPermissions() {
        return organisationPermissions;
    }

    public boolean isUserPermissions() {
        return userPermissions;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public void setCameraPermissions(boolean cameraPermissions) {
        this.cameraPermissions = cameraPermissions;
    }

    public void setMicrophone(boolean microphone) {
        this.microphone = microphone;
    }

    public void setMicrophonePermissions(boolean microphonePermissions) {
        this.microphonePermissions = microphonePermissions;
    }

    public void setOrganisationPermissions(boolean organisationPermissions) {
        this.organisationPermissions = organisationPermissions;
    }

    public void setPermittedOrganisations(ArrayList<String> permittedOrganisations) {
        this.permittedOrganisations = permittedOrganisations;
    }

    public void setUserIDs(ArrayList<Integer> userIDs) {
        this.userIDs = userIDs;
    }

    public void setUserPermissions(boolean userPermissions) {
        this.userPermissions = userPermissions;
    }
}
