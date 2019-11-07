package ru.sbt.mipt.oop;


class EventManager {
    static void manageSmartHome(SmartHome smartHome) {
        for (SensorEvent event = NextSensorEvent.getNextSensorEvent();
             event != null;
             event = NextSensorEvent.getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            LightEventProcessor.processEvent(smartHome, event);
            DoorEventProcessor.processEvent(smartHome, event);
        }
    }
}