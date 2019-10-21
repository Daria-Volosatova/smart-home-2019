package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor{
    private SensorEvent event;
    private SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.event = event;
        this.smartHome = smartHome;
    }

    public void processEvent() {
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
