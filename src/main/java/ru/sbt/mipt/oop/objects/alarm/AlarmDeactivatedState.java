package ru.sbt.mipt.oop.objects.alarm;

public class AlarmDeactivatedState implements AlarmState {
    private Alarm alarm;
    private String code;
    private AlarmState state;

    public AlarmDeactivatedState(Alarm alarm) {
    }

    @Override
    public void activate(String inputPassword) {
        AlarmState newState = new AlarmActivatedState(alarm, inputPassword);
        alarm.changeState(newState);
        System.out.println("Alarm activated");
    }

    @Override
    public void deactivate(String inputPassword) {
        System.out.println("Alarm is already deactivated");
    }

}
