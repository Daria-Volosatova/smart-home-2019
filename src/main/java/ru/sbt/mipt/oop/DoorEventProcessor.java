package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventProcessor implements EventProcessor{private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void processEvent(SensorEvent event) {
        if (!isDoorEvent(event)){return;}
        // событие от источника света
        smartHome.execute(actionable -> {
            Door door = (Door) actionable;
            if (door.getId().equals(event.getObjectId())) {
                if (event.getType() == DOOR_CLOSED) {
                    door.close();
                    System.out.println("Door " + door.getId() + " was closed.");
                } else {
                    door.open();
                    System.out.println("Door " + door.getId() + " was closed.");
                }
            }
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED);
    }
}
