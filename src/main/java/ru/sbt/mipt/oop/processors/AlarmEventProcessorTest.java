package ru.sbt.mipt.oop.processors;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.objects.alarm.Alarm;
import ru.sbt.mipt.oop.objects.alarm.AlarmActivatedState;
import ru.sbt.mipt.oop.objects.alarm.AlarmDeactivatedState;

import java.awt.im.spi.InputMethod;

import static org.junit.jupiter.api.Assertions.*;

class AlarmEventProcessorTest {
    private String code = "abc";

    @Test
    void alarmIsDeactivated() {
        Alarm alarm = new Alarm();
        assertTrue(alarm.getState() instanceof AlarmDeactivatedState);
    }

    @Test
    void processEventActivationAlarm() {
        Alarm alarm = new Alarm();
        alarm.activateAlarm(code);
        assertTrue(alarm.getState() instanceof AlarmActivatedState);
    }

    @Test
    void processEventDeactivationAlarm() {
        Alarm alarm = new Alarm();
        alarm.activateAlarm(code);
        alarm.deactivateAlarm(code);
        assertTrue(alarm.getState() instanceof AlarmDeactivatedState);
    }
}