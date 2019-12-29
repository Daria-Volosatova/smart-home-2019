package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.objects.Actionable;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean execute(Action action) {
        boolean executed = action.execute(this);
        for (Light light : lights) {
            executed |= light.execute(action);
        }
        for (Door door : doors) {
            executed |= door.execute(action);
        }
        return executed;
    }


}
