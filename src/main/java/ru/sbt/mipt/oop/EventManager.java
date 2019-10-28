package ru.sbt.mipt.oop;


class EventManager {
    static void manageSmartHome(SmartHome smartHome) {
        for (SensorEvent event = NextSensorEvent.getNextSensorEvent();
             event != null;
             event = NextSensorEvent.getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            EventProcessor.processEvent(smartHome, event);
            SensorCommand command = new SensorCommand(SensorCommandType.LIGHT_OFF, Light.getId());
            MessageManager.sendCommand(command);
        }
    }
}