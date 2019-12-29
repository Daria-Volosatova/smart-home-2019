package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.objects.Actionable;
import ru.sbt.mipt.oop.objects.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    public Alarm alarm;

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public SmartHome() {
        this(new ArrayList<>());
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public boolean execute(Action action) {
        boolean executed = action.execute(this);
        for (Room room : rooms) {
            executed |= room.execute(action);
        }
        return executed;
    }

    public Alarm getAlarm(){
        return this.alarm;
    }
}

