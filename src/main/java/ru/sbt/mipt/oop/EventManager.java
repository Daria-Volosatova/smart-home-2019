package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.EventSensor.getNextSensorEvent;
import static ru.sbt.mipt.oop.EventType.*;

class EventManager {
    static void manage(SmartHome smartHome) {
        for (EventSensor event = getNextSensorEvent();
             event != null;
             event = getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            EventType type = event.getType();
            if ((type == LIGHT_ON) | (type == LIGHT_OFF)) {
                LightEventProcessor.processEvent(smartHome, event);
            } else if ((type == DOOR_OPEN) | (type == DOOR_CLOSED)) {
                DoorEventProcessor.processEvent(smartHome, event);
            }
        }
    }

    private static void sendCommand(CommandSensor command) {
        System.out.println("Pretend we're sending command " + command);
    }
}