package ru.sbt.mipt.oop.processors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.objects.Light;
import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LightEventProcessorTest {

    @Test
    void processEventCorrectLightOn() {
        SmartHome home = new SmartHome();
        Light light1 = new Light("light125", false);
        Light light2 = new Light("light3", true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_ON, light1.getId());
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_ON, light2.getId());
        LightEventProcessor lightEventProcessor1 = new LightEventProcessor(home);
        LightEventProcessor lightEventProcessor2 = new LightEventProcessor(home);
        lightEventProcessor1.processEvent(event1);
        lightEventProcessor2.processEvent(event2);
        Assert.assertTrue(light1.isOn());
        Assert.assertTrue(light2.isOn());
    }

    @Test
    void processEventCorrectLightOff() {
        SmartHome home = new SmartHome();
        Light light1 = new Light("light125", false);
        Light light2 = new Light("light3", true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_OFF, light1.getId());
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_OFF, light2.getId());
        LightEventProcessor lightEventProcessor1 = new LightEventProcessor(home);
        LightEventProcessor lightEventProcessor2 = new LightEventProcessor(home);
        lightEventProcessor1.processEvent(event1);
        lightEventProcessor2.processEvent(event2);
        Assert.assertFalse(light1.isOn());
        Assert.assertFalse(light2.isOn());
    }
}