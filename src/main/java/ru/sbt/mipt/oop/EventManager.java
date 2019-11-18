package ru.sbt.mipt.oop;


class EventManager {
    static void manageSmartHome(SmartHome smartHome) {
        for (SensorEvent event = NextSensorEvent.getNextSensorEvent();
             event != null;
             event = NextSensorEvent.getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            LightEventProcessor lightEventProcessor = new LightEventProcessor();
            lightEventProcessor.processEvent(smartHome, event);
            HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor();
            hallDoorEventProcessor.processEvent(smartHome, event);
            DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
            doorEventProcessor.processEvent(smartHome, event);
        }
    }
}