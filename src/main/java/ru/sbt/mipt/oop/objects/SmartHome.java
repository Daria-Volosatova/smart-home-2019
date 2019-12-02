package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome{
    private static Alarm alarm;
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
        alarm = new Alarm();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public static Alarm getAlarm(){
        return alarm;
    }
}
