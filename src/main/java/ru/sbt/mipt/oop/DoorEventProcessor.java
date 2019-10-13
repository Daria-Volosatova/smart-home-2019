package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.EventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.EventType.DOOR_OPEN;

public class DoorEventProcessor {
    public static void processEvent(SmartHome smartHome, EventSensor event) {
        if (!isDoorEvent(event)) {
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.open();
                        System.out.println("Door " + door.getId() + " in " + room.getName() + " was opened.");
                    } else {
                        door.close();
                        System.out.println("Door " + door.getId() + " in " + room.getName() + " was closed.");
                    }
                }
            }
        }
    }

    private static boolean isDoorEvent(EventSensor event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
