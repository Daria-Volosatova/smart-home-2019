package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.objects.*;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

public class HallDoorEventProcessor {
    private static SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        HallDoorEventProcessor.smartHome = smartHome;
    }

    public static void processEvent(SensorEvent event) {
        if (!isDoorClosedEvent(event)) {
            return;
        }

        boolean isHallDoor = smartHome.execute((Actionable actionable) -> {
            if (actionable instanceof Room) {
                Room room = (Room) actionable;
                if (room.getName().equals("hall")) {
                    return room.execute((Actionable roomActionable) -> {
                        if (roomActionable instanceof Door) {
                            Door door = (Door) roomActionable;
                            if (door.getId().equals(event.getObjectId())) {
                                door.close();
                                System.out.println("Hall door " + door.getId() + " was closed.");
                                return true;
                            }
                        }
                        return false;
                    });
                }
            }
            return false;
        });

        if (isHallDoor) {
            boolean lightsOff = smartHome.execute((Actionable actionable) -> {
                if (actionable instanceof Light) {
                    Light light = (Light) actionable;
                    light.setOn(false);
                    return true;
                }
                return false;
            });
            if (lightsOff) {
                System.out.println("All lights were turned off.");
            }
        }
    }
    private static boolean isDoorClosedEvent(SensorEvent event) {
        return event.getType() == SensorEventType.DOOR_CLOSED;
    }
}
