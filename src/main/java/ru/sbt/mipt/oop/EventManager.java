package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.processors.LightEventProcessor;
import ru.sbt.mipt.oop.sensors.SensorCommand;
import ru.sbt.mipt.oop.sensors.SensorEvent;

class EventManager {
    static void manage(SmartHome smartHome) {
        SensorEvent event = SensorEvent.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            new LightEventProcessor(smartHome, event).processEvent();
            new DoorEventProcessor(smartHome, event).processEvent();
            new HallDoorEventProcessor(smartHome, event).processEvent();
            event = SensorEvent.getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}