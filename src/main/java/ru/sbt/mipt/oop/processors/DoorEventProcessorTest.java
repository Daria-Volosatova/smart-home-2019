package ru.sbt.mipt.oop.processors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.objects.Door;
import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

class DoorEventProcessorTest {

    @Test
    void processEventCorrectDoorOpen() {
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(true, doorId1);
        String doorId2 = "15";
        Door door2 = new Door(false, doorId2);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId2);
        DoorEventProcessor doorEventProcessor1 = new DoorEventProcessor(home, event1);
        DoorEventProcessor doorEventProcessor2 = new DoorEventProcessor(home, event2);
        doorEventProcessor1.processEvent();
        doorEventProcessor2.processEvent();
        Assert.assertTrue(door1.isOpen());
        Assert.assertTrue(door2.isOpen());
    }

    @Test
    void processEventCorrectDoorClose() {
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(true, doorId1);
        String doorId2 = "15";
        Door door2 = new Door(false, doorId2);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door1), "room1"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door2), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId2);
        DoorEventProcessor doorEventProcessor1 = new DoorEventProcessor(home, event1);
        DoorEventProcessor doorEventProcessor2 = new DoorEventProcessor(home, event2);
        doorEventProcessor1.processEvent();
        doorEventProcessor2.processEvent();
        Assert.assertTrue(!door1.isOpen());
        Assert.assertTrue(!door2.isOpen());
    }
}