package com.example.softwareengineeringprototype3.production;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user1;

    @BeforeEach
    void setUp() {
        user1 = new User(10000, "user1");
    }

    @AfterEach
    void tearDown() {
        user1 = null;
    }

    @Test
    void getName() {
        assertEquals("user1", user1.getName());
    }

    @Test
    void getUserID() {
        assertEquals(10000, user1.getUserID());
    }

    @Test
    void getOrganisation() {
        assertEquals("N/A", user1.getOrganisation());
    }

    @Test
    void isCameraOn() {
        assertEquals(false, user1.isCameraOn());
    }

    @Test
    void isMicrophoneOn() {
        assertEquals(false, user1.isMicroPhoneOn());
    }

    @Test
    void setCamera() {
        assertFalse(user1.isCameraOn());
        user1.setCamera(true);
        assertTrue(user1.isCameraOn());
    }

    @Test
    void setMicrophone() {
        assertFalse(user1.isMicroPhoneOn());
        user1.setMicroPhone(true);
        assertTrue(user1.isMicroPhoneOn());
    }
}