package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor{
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
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

    private static boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
