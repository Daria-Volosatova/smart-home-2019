package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class HallDoorEventProcessorTest {

    @Test
    void processEventAllLightOff() {
        SmartHome home = new SmartHome();
        Door door1 = new Door("door125", true);
        Light light1 = new Light("light125", true);
        Light light2 = new Light("light3", true);
        home.addRoom(new Room(Arrays.asList(light1), Arrays.asList(door1), "hall"));
        home.addRoom(new Room(Arrays.asList(light2),  Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, door1.getId());
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(home);
        hallDoorEventProcessor.processEvent(event1);
        Assert.assertFalse(light1.isOn());
        Assert.assertFalse(light2.isOn());
        Assert.assertFalse(door1.isOpen());
    }

    @Test
    void processEventLightOffWhenDoorOpening() {
        SmartHome home = new SmartHome();
        Door door1 = new Door("door125", true);
        Light light1 = new Light("light125", true);
        Light light2 = new Light("light3", true);
        home.addRoom(new Room(Arrays.asList(light1), Arrays.asList(door1), "hall"));
        home.addRoom(new Room(Arrays.asList(light2),  Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, door1.getId());
        HallDoorEventProcessor hallDoorEventProcessor1 = new HallDoorEventProcessor(home);
        hallDoorEventProcessor1.processEvent(event1);
        Assert.assertTrue(light1.isOn());
        Assert.assertTrue(light2.isOn());
        Assert.assertTrue(door1.isOpen());
    }
}