package ru.sbt.mipt.oop;

class EventManager {
    static void manage(SmartHome smartHome) {
        SensorEvent event = SensorEvent.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            new LightEventProcessor(smartHome, event).processEvent();
            new DoorEventProcessor(smartHome, event).processEvent();
            new HallDoorEventProcessor(smartHome, event).processEvent();
            event = SensorEvent.getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}