package ru.sbt.mipt.oop.processors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.objects.Door;
import ru.sbt.mipt.oop.objects.Light;
import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

class HallDoorEventProcessorTest {

    @Test
    void processEventAllLightOff() {
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(true, doorId1);
        String lightId1 = "125";
        Light light1 = new Light(lightId1, true);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, true);
        home.addRoom(new Room(Arrays.asList(light1), Arrays.asList(door1), "hall"));
        home.addRoom(new Room(Arrays.asList(light2),  Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId1);
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(home, event1);
        hallDoorEventProcessor.processEvent();
        Assert.assertTrue(!light1.isOn());
        Assert.assertTrue(!light2.isOn());
        Assert.assertTrue(!door1.isOpen());
    }

    @Test
    void processEventLightOffWhenDoorOpening() {
        SmartHome home =new SmartHome();
        String doorId1 = "125";
        Door door1 = new Door(false, doorId1);
        String lightId1 = "125";
        Light light1 = new Light(lightId1, false);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, false);
        home.addRoom(new Room(Arrays.asList(light1), Arrays.asList(door1), "hall"));
        home.addRoom(new Room(Arrays.asList(light2),  Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId1);
        HallDoorEventProcessor hallDoorEventProcessor1 = new HallDoorEventProcessor(home, event1);
        hallDoorEventProcessor1.processEvent();
        Assert.assertTrue(!light1.isOn());
        Assert.assertTrue(!light2.isOn());
        Assert.assertTrue(door1.isOpen());
    }

}