package ru.sbt.mipt.oop;

class EventManager {
    static void manage(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            new LightEventProcessor(smartHome).processEvent(event);
            new DoorEventProcessor(smartHome).processEvent(event);
            new HallDoorEventProcessor(smartHome).processEvent(event);
            event = getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}