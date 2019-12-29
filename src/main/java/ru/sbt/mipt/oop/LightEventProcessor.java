package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor{
    private SmartHome smartHome;

    public LightEventProcessor(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void processEvent(SensorEvent event) {
        if (!isLightEvent(event)){
            return;
        }
        // событие от источника света
        smartHome.execute((Actionable actionable) -> {
            if (actionable instanceof Light) {
                Light light = (Light) actionable;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " was turned off.");
                    }
                    return true;
                }
            }
            return false;
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        return (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }
}
