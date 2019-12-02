package ru.sbt.mipt.oop;

public class Light implements Actionable{
    private boolean isOn;
    private final String id;
    private Room room;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }
    public Room getRoom() {
        return room;
    }

    public void setStatus(boolean status) {
        this.isOn = isOn();
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    @Override
    public void execute(Action action) {

    }
}
