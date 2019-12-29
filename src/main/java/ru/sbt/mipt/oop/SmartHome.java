package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

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
}
