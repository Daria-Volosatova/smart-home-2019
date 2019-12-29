package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.objects.alarm.Alarm;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public AlarmEventProcessor(SmartHome smartHome){ this.smartHome = smartHome;}


    public boolean isAlarmEvent(SensorEvent event){
        return (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE);
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (isAlarmEvent(event)){
            Alarm alarm = smartHome.getAlarm();
            if (event.getType() == ALARM_ACTIVATE){
                String currentCode = alarm.getCode();
                alarm.activateAlarm(currentCode);
            } else {
                String currentCode = alarm.getCode();
                alarm.deactivateAlarm(currentCode);
            }
        }
    }
}
