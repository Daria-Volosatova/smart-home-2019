package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.objects.Door;
import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    private SensorEvent event;
    private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.event = event;
        this.smartHome = smartHome;
    }

    public void processEvent() {
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

    private static boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
