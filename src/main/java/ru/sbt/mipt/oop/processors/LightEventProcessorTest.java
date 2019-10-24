package ru.sbt.mipt.oop.processors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.objects.Light;
import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.processors.LightEventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

class LightEventProcessorTest {

    @Test
    void processEventCorrectLightOn() {
        SmartHome home =new SmartHome();
        String lightId1 = "125";
        Light light1 = new Light(lightId1, false);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_ON, lightId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_ON, lightId2);
        LightEventProcessor lightEventProcessor1 = new LightEventProcessor(home, event1);
        LightEventProcessor lightEventProcessor2 = new LightEventProcessor(home, event2);
        lightEventProcessor1.processEvent();
        lightEventProcessor2.processEvent();
        Assert.assertTrue(light1.isOn());
        Assert.assertTrue(light2.isOn());
    }

    @Test
    void processEventCorrectLightOff() {
        SmartHome home =new SmartHome();
        String lightId1 = "125";
        Light light1 = new Light(lightId1, false);
        String lightId2 = "3";
        Light light2 = new Light(lightId2, true);
        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId2);
        LightEventProcessor lightEventProcessor1 = new LightEventProcessor(home, event1);
        LightEventProcessor lightEventProcessor2 = new LightEventProcessor(home, event2);
        lightEventProcessor1.processEvent();
        lightEventProcessor2.processEvent();
        Assert.assertTrue(!light1.isOn());
        Assert.assertTrue(!light2.isOn());
    }
}