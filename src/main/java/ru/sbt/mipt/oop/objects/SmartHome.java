package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.objects.Room;
import ru.sbt.mipt.oop.objects.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome{
    Collection<Room> rooms;
    private Alarm alarm;

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

    public void activateAlarm(String code){

        this.alarm.activateAlarm(code);
    }

    public void deactivateAlarm(String code){

        this.alarm.deactivateAlarm(code);
    }

    public Alarm getAlarm(){
        return alarm;
    }
}
