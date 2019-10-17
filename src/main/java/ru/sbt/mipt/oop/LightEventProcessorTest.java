package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LightEventProcessorTest {

    @Test
    void processEventCorrectLightOn() {
        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        SmartHome home =new SmartHome();
        String lightId1 = "125";
        Light light1 = new Light(lightId1, false);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_ON, lightId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_ON, lightId2);
        lightEventProcessor.processEvent(home, event1);
        lightEventProcessor.processEvent(home, event2);
        Assert.assertTrue(light1.isOn());
        Assert.assertTrue(light2.isOn());
    }

    @Test
    void processEventCorrectLightOff() {
        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        SmartHome home =new SmartHome();
        String lightId1 = "125";
        Light light1 = new Light(lightId1, false);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId2);
        lightEventProcessor.processEvent(home, event1);
        lightEventProcessor.processEvent(home, event2);
        Assert.assertTrue(!light1.isOn());
        Assert.assertTrue(!light2.isOn());
    }
}