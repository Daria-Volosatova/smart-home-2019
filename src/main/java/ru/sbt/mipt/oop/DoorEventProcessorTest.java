package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DoorEventProcessorTest {

    @Test
    void processEventCorrectDoorOpen() {
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(true, doorId1);
        String doorId2 = "15";
        Door door2 = new Door(false, doorId2);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId2);
        doorEventProcessor.processEvent(home, event1);
        doorEventProcessor.processEvent(home, event2);
        Assert.assertTrue(door1.isOpen());
        Assert.assertTrue(door2.isOpen());
    }

    @Test
    void processEventCorrectDoorClose() {
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(true, doorId1);
        String doorId2 = "15";
        Door door2 = new Door(false, doorId2);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId2);
        doorEventProcessor.processEvent(home, event1);
        doorEventProcessor.processEvent(home, event2);
        Assert.assertTrue(!door1.isOpen());
        Assert.assertTrue(!door2.isOpen());
    }
}