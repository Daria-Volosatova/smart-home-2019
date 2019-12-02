package ru.sbt.mipt.oop;

public class Door implements Actionable{
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setStatus(boolean status) {
        this.isOpen = isOpen();
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void open() {
        setOpen(true);
    }

    public void close() {
        setOpen(false);
    }

    public boolean isOpen() {
        return isOpen;
    }


    @Override
    public void execute(Action action) {
        action.executeObj(this);
    }
}
}
