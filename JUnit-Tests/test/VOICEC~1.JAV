package com.example.softwareengineeringprototype3.production;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VoiceCallTest {

    VoiceCall voiceCall;
    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp() {
        voiceCall = new VoiceCall();
        user1 = new User(10000, "user1");
        user2 = new User(10001, "user2", "SETU");
        user3 = new User(99999, "user3", "another university");
    }

    @AfterEach
    void tearDown() {
        voiceCall = null;
        user1 = null;
        user2 = null;
        user3 = null;
    }

    @Test
    void permissionToJoinVoiceCallWithNoPermissions() {
        voiceCall.setMicrophonePermissions(false);
        voiceCall.setCameraPermissions(false);
        voiceCall.setOrganisationPermissions(false);
        voiceCall.setUserPermissions(false);

        assertTrue(voiceCall.permissionToJoinVoiceCall(user1));
        assertTrue(voiceCall.permissionToJoinVoiceCall(user2));
        assertTrue(voiceCall.permissionToJoinVoiceCall(user3));
    }

    @Test
    void userPermissions() {
        voiceCall.setMicrophonePermissions(false);
        voiceCall.setCameraPermissions(false);
        voiceCall.setOrganisationPermissions(false);
        voiceCall.setUserPermissions(true);
        voiceCall.addUserID(10000);
        voiceCall.addUserID(99999);

        assertTrue(voiceCall.permissionToJoinVoiceCall(user1));
        assertFalse(voiceCall.permissionToJoinVoiceCall(user2));
        assertTrue(voiceCall.permissionToJoinVoiceCall(user3));
    }

    @Test
    void organisationPermissions() {
        voiceCall.setMicrophonePermissions(false);
        voiceCall.setCameraPermissions(false);
        voiceCall.setOrganisationPermissions(true);
        voiceCall.setUserPermissions(false);
        voiceCall.addOrganisation("SETU");

        assertFalse(voiceCall.permissionToJoinVoiceCall(user1));
        assertTrue(voiceCall.permissionToJoinVoiceCall(user2));
        assertFalse(voiceCall.permissionToJoinVoiceCall(user3));
    }

    @Test
    void cameraPermissions() {
        voiceCall.setMicrophonePermissions(false);
        voiceCall.setCameraPermissions(true);
        voiceCall.setOrganisationPermissions(false);
        voiceCall.setUserPermissions(false);
        voiceCall.setCamera(true);

        user2.setCamera(true);

        assertFalse(user1.isMicroPhoneOn());
        assertTrue(voiceCall.permissionToJoinVoiceCall(user1));
        assertTrue(user1.isCameraOn());

        assertTrue(user2.isCameraOn());
        assertTrue(voiceCall.permissionToJoinVoiceCall(user2));
        assertTrue(user2.isCameraOn());
    }

    @Test
    void microPhonePermissions() {
        voiceCall.setMicrophonePermissions(true);
        voiceCall.setCameraPermissions(false);
        voiceCall.setOrganisationPermissions(false);
        voiceCall.setUserPermissions(false);
        voiceCall.setMicrophone(false);

        user2.setMicroPhone(true);

        assertFalse(user1.isMicroPhoneOn());
        assertTrue(voiceCall.permissionToJoinVoiceCall(user1));
        assertFalse(user1.isMicroPhoneOn());

        assertTrue(user2.isMicroPhoneOn());
        assertTrue(voiceCall.permissionToJoinVoiceCall(user2));
        assertFalse(user2.isMicroPhoneOn());
    }

    @Test
    void addUserID() {
        ArrayList<Integer> userIDs = voiceCall.getUserIDs();

        assertFalse(userIDs.contains(22222));
        assertTrue(voiceCall.addUserID(22222));
        assertTrue(userIDs.contains(22222));

        assertFalse(voiceCall.addUserID(22222));
    }

    @Test
    void addOrganisation() {
        ArrayList<String> organisations = voiceCall.getPermittedOrganisations();

        assertFalse(organisations.contains("SETU"));
        assertTrue(voiceCall.addOrganisation("SETU"));
        assertTrue(organisations.contains("SETU"));

        assertFalse(voiceCall.addOrganisation("SETU"));
    }

    @Test
    void deleteUserID() {
        ArrayList<Integer> userIDs = voiceCall.getUserIDs();
        voiceCall.addUserID(22222);

        assertTrue(userIDs.contains(22222));
        assertTrue(voiceCall.deleteUserID(22222));
        assertFalse(userIDs.contains(22222));

        assertFalse(voiceCall.deleteUserID(22222));
    }

    @Test
    void deleteOrganisation() {
        ArrayList<String> organisations = voiceCall.getPermittedOrganisations();
        voiceCall.addOrganisation("SETU");

        assertTrue(organisations.contains("SETU"));
        assertTrue(voiceCall.deleteOrganisation("SETU"));
        assertFalse(organisations.contains("SETU"));

        assertFalse(voiceCall.deleteOrganisation("SETU"));
    }

    @Test
    void clearUserIDs() {
        ArrayList<Integer> userIDs = voiceCall.getUserIDs();
        voiceCall.addUserID(22222);
        voiceCall.addUserID(11111);
        voiceCall.addUserID(33333);

        assertEquals(3, userIDs.size());

        voiceCall.clearUserIDs();
        assertEquals(0, userIDs.size());
    }

    @Test
    void clearUserID() {
        ArrayList<String> organisations = voiceCall.getPermittedOrganisations();
        voiceCall.addOrganisation("SETU");
        voiceCall.addOrganisation("a");
        voiceCall.addOrganisation("b");

        assertEquals(3, organisations.size());

        voiceCall.clearOrganisations();
        assertEquals(0, organisations.size());
    }

    @Test
    void isCamera() {
        assertTrue(voiceCall.isCamera());
    }

    @Test
    void isMicrophone() {
        assertTrue(voiceCall.isMicrophone());
    }

    @Test
    void isMicrophonePermissions() {
        assertFalse(voiceCall.isMicrophonePermissions());
    }

    @Test
    void isCameraPermissions() {
        assertFalse(voiceCall.isCameraPermissions());
    }

    @Test
    void isOrganisationPermissions() {
        assertTrue(voiceCall.isOrganisationPermissions());
    }

    @Test
    void isUserPermissions() {
        assertTrue(voiceCall.isUserPermissions());
    }

    @Test
    void setCamera() {
        assertTrue(voiceCall.isCamera());
        voiceCall.setCamera(false);
        assertFalse(voiceCall.isCamera());
    }

    @Test
    void setMicrophone() {
        assertTrue(voiceCall.isMicrophone());
        voiceCall.setMicrophone(false);
        assertFalse(voiceCall.isMicrophone());
    }

    @Test
    void setCameraPermissions() {
        assertFalse(voiceCall.isCameraPermissions());
        voiceCall.setCameraPermissions(true);
        assertTrue(voiceCall.isCameraPermissions());
    }

    @Test
    void setMicrophonePermissions() {
        assertFalse(voiceCall.isMicrophonePermissions());
        voiceCall.setMicrophonePermissions(true);
        assertTrue(voiceCall.isMicrophonePermissions());
    }

    @Test
    void setUserPermissions() {
        assertTrue(voiceCall.isUserPermissions());
        voiceCall.setUserPermissions(false);
        assertFalse(voiceCall.isUserPermissions());
    }

    @Test
    void setOrganisationPermissions() {
        assertTrue(voiceCall.isOrganisationPermissions());
        voiceCall.setOrganisationPermissions(false);
        assertFalse(voiceCall.isOrganisationPermissions());
    }
}