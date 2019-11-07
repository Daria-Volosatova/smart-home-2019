package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    public static void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) {
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if(room.getName().equals("hall") & event.getType() == DOOR_CLOSED) {
                    HallDoorEventProcessor.processEvent(smartHome, event);
                    return;
                }
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

    private static boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
