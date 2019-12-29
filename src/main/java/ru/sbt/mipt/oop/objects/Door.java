package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.Action;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(String id, boolean isOpen) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public void open() {
        setOpen(true);
    }

    public void close() {
        setOpen(false);
    }

    @Override
    public boolean execute(Action action) {
        return action.execute(this);
    }
}
