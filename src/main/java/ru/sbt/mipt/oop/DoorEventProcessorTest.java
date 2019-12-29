package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class DoorEventProcessorTest {

    @Test
    void processEventCorrectDoorOpen() {
        SmartHome home = new SmartHome();
        Door door1 = new Door("door125", true);
        Door door2 = new Door("door15", false);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, door1.getId());
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_OPEN, door2.getId());
        DoorEventProcessor doorEventProcessor1 = new DoorEventProcessor(home);
        DoorEventProcessor doorEventProcessor2 = new DoorEventProcessor(home);
        doorEventProcessor1.processEvent(event1);
        doorEventProcessor2.processEvent(event2);
        Assert.assertTrue(door1.isOpen());
        Assert.assertTrue(door2.isOpen());
    }

    @Test
    void processEventCorrectDoorClose() {
        SmartHome home = new SmartHome();
        Door door1 = new Door("door125", true);
        Door door2 = new Door("door15", false);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, door1.getId());
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, door2.getId());
        DoorEventProcessor doorEventProcessor1 = new DoorEventProcessor(home);
        DoorEventProcessor doorEventProcessor2 = new DoorEventProcessor(home);
        doorEventProcessor1.processEvent(event1);
        doorEventProcessor2.processEvent(event2);
        Assert.assertTrue(!door1.isOpen());
        Assert.assertTrue(!door2.isOpen());
    }
}