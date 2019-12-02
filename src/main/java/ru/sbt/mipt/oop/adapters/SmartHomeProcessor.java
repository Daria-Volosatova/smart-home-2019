package ru.sbt.mipt.oop.adapters;

import ru.sbt.mipt.oop.*;

public class SmartHomeProcessor {
    public static void turnOffLight(SmartHome smartHome) {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.turnOff();
                System.out.println("Light " + light.getId() + " was turned off.");
            }
        }
    }

    public static Door processDoor(SmartHome smartHome, SensorEvent event){
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())){
                return door;
                }
            }
        }
        return null;
    }

    public static boolean isHallRoom(SmartHome smartHome, SensorEvent event){
        for (Room room : smartHome.getRooms()){
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (room.getName() == "hall"){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
                }
        return false;
        }
    }
