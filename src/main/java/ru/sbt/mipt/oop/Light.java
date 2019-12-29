package ru.sbt.mipt.oop;

public class Light implements Actionable {
    private final String id;
    private boolean isOn;

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

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    @Override
    public boolean execute(Action action) {
        return action.execute(this);
    }
}
