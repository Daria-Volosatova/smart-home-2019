package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.objects.alarm.Alarm;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isAlarmEvent(event)){
            if (event.getType() == ALARM_ACTIVATE){
                String currentCode = Alarm.getCode();
                smartHome.activateAlarm(currentCode);
            } else {
                String currentCode = Alarm.getCode();
                smartHome.deactivateAlarm(currentCode);
            }
        }
    }

    public boolean isAlarmEvent(SensorEvent event){
        return (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE);
    }
}
