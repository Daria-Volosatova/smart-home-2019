package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.objects.Actionable;
import ru.sbt.mipt.oop.objects.Door;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smarthome) {
        this.smartHome = smarthome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!isDoorEvent(event)) {
            return;
        }
        smartHome.execute((Actionable actionable) -> {
            if (actionable instanceof Door) {
                Door door = (Door) actionable;
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_CLOSED) {
                        door.close();
                        System.out.println("Door " + door.getId() + " was closed.");
                    } else {
                        door.open();
                        System.out.println("Door " + door.getId() + " was opened.");
                    }
                    return true;
                }
            }
            return false;
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED);
    }
}
