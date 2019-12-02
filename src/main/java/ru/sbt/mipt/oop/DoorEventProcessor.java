package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.adapters.SmartHomeProcessor;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        if (event.getType() == DOOR_OPEN) {
            Door door = SmartHomeProcessor.processDoor(smartHome, event);
            door.open();
            System.out.println("Door " + door.getId() + " was opened.");
        } else if (event.getType() == DOOR_CLOSED) {
            Door door = SmartHomeProcessor.processDoor(smartHome, event);
            door.close();
            System.out.println("Door " + door.getId() + " was closed.");
        } else {
            return;
        }
    }
}
