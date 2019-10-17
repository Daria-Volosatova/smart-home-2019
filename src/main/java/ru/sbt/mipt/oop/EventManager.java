package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEvent.getNextSensorEvent;
import static ru.sbt.mipt.oop.SensorEventType.*;

class EventManager {
    static void manage(SmartHome smartHome) {
        for (SensorEvent event = getNextSensorEvent();
             event != null;
             event = getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            SensorEventType type = event.getType();
            if ((type == LIGHT_ON) | (type == LIGHT_OFF)) {
                LightEventProcessor.processEvent(smartHome, event);
            } else if ((type == DOOR_OPEN) | (type == DOOR_CLOSED)) {
                HallDoorEventProcessor.processEvent(smartHome, event);
                DoorEventProcessor.processEvent(smartHome, event);
            }
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}