package ru.sbt.mipt.oop.objects.alarm;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {
    private Alarm alarm = new Alarm();

    @Test
    public void activateDeactivatedTest() throws IOException {
        String alarmCode = "goodpassword";
        AlarmState currentState = new AlarmDeactivatedState(alarm);

        alarm.changeState(currentState);
        alarm.activateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmActivatedState);
    }

    @Test
    public void deactivateActivatedTest() throws IOException {
        String alarmCode = "goodpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmActivatedState(alarm);

        alarm.changeState(currentState);
        alarm.deactivateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmDeactivatedState);
    }

    @Test
    public void wrongPasswordTest() throws IOException {
        String alarmCode = "goodpassword";
        String wrongCode = "verybadpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmActivatedState(alarm);

        alarm.changeState(currentState);
        alarm.deactivateAlarm(wrongCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmAlertState);
    }

    @Test
    public void deactivatedAlertStateTest() throws IOException {
        String alarmCode = "goodpassword";
        String wrongCode = "verybadpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmActivatedState(alarm);

        alarm.changeState(currentState);
        alarm.deactivateAlarm(wrongCode);
        alarm.deactivateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmDeactivatedState);
    }

    @Test
    public void deactivateDeactivatedTest() throws IOException {
        String alarmCode = "goodpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmActivatedState(alarm);

        alarm.changeState(currentState);
        alarm.deactivateAlarm(alarmCode);
        alarm.deactivateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmDeactivatedState);
    }

    @Test
    public void activateActivatedTest() throws IOException {
        String alarmCode = "goodpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmActivatedState(alarm);

        alarm.changeState(currentState);
        alarm.activateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmActivatedState);
    }

    @Test
    public void deactivateAlertTest() throws IOException {
        String alarmCode = "goodpassword";
        alarm.setCode(alarmCode);
        AlarmState currentState = new AlarmAlertState(alarm);

        alarm.changeState(currentState);
        alarm.deactivateAlarm(alarmCode);

        AlarmState finalState = alarm.getState();
        assertTrue(finalState instanceof AlarmDeactivatedState);
    }
}