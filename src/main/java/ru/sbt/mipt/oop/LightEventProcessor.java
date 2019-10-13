package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.EventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.EventType.LIGHT_ON;

public class LightEventProcessor {
    public static void processEvent(SmartHome smartHome, EventSensor event) {
        if (!isLightEvent(event)) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.turnOn();
                        System.out.println("Light " + light.getId() + " in " + room.getName() + " was turned on.");
                    } else {
                        light.turnOff();
                        System.out.println("Light " + light.getId() + " in " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }

    private static boolean isLightEvent(EventSensor event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
