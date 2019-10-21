package ru.sbt.mipt.oop;

public class HallDoorEventProcessor {
    private static SensorEvent event;
    private static SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.event = event;
        this.smartHome = smartHome;
    }

    public static void processEvent() {
        if (!isDoorClosedEvent(event)) {
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (room.getName().equals("hall")) {
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                light.setOn(false);
                            }
                        }
                    }
                    System.out.println("All lights were turned off.");
                }
            }
        }
    }

    private static boolean isDoorClosedEvent(SensorEvent event) {
        return event.getType() == SensorEventType.DOOR_CLOSED;
    }
}
