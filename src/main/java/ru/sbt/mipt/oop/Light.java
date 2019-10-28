package ru.sbt.mipt.oop;

public class Light {
    private boolean isOn;
    private static String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public static String getId() {
        return id;
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
}
