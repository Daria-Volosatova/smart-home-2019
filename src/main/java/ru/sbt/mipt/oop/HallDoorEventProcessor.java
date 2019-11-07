package ru.sbt.mipt.oop;

public class HallDoorEventProcessor implements EventProcessor{
    public static void processEvent(SmartHome smartHome, SensorEvent event) {
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                SensorCommand command = new SensorCommand(SensorCommandType.LIGHT_OFF, light.getId());
                                MessageManager.sendCommand(command);
                                light.setOn(false);
                            }
                        }
                        System.out.println("All lights were turned off.");
                    }
}
