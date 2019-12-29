package ru.sbt.mipt.oop.objects.alarm;

public class Alarm {
    private AlarmState state;
    private static String code;

    public Alarm(){
        this.state = new AlarmDeactivatedState(this);
    }

    public AlarmState getState(){
        return state;
    }

    public void setCode(String newCode){
        code = newCode;
    }

    public String getCode(){
        return code;
    }

    public void changeState(AlarmState newState){
        this.state = newState;
    }

    public void activateAlarm(String code){
        state.activate(code);
    }

    public void deactivateAlarm(String code){
        state.deactivate(code);
    }

}
