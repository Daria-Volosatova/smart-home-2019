package ru.sbt.mipt.oop.objects.alarm;

public interface AlarmState {
    void activate (String inputPassword);
    void deactivate (String inputPassword);
    void activateAlert();
}
