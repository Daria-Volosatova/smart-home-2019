package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.adapters.SmartHomeProcessor;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == DOOR_CLOSED) {
            if (SmartHomeProcessor.isHallRoom(smartHome, event)) {
                SmartHomeProcessor.turnOffLight(smartHome);
                System.out.println("All lights were turned off.");
            }
        } else {
            return;
        }
    }
}
