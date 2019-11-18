package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) {
            return;
        }
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall") & event.getType() == DOOR_CLOSED) {
                for (Light light : room.getLights()) {
                    SensorCommand command = new SensorCommand(SensorCommandType.LIGHT_OFF, light.getId());
                    MessageManager.sendCommand(command);
                    light.setOn(false);

                }

            }
        }

        System.out.println("All lights were turned off.");
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
