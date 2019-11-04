package ru.sbt.mipt.oop.objects.alarm;

import ru.sbt.mipt.oop.objects.SmartHome;
import ru.sbt.mipt.oop.processors.EventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.*;

public class AlarmDecorator implements EventProcessor {
    private static EventProcessor eventProcessor;

    public AlarmDecorator(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
    }


    public static void processEvent(SmartHome smartHome, SensorEvent event) {
        Alarm alarm = smartHome.getAlarm();

        if (alarm.getState() instanceof AlarmAlertState){

            // режим тревоги, события не обрабатываются
            return;
        }
        else if (alarm.getState() instanceof AlarmDeactivatedState){

            // сигнализация деактивирована, обрабатываем событие
            EventProcessor.processEvent(smartHome, event);
        }
        else {
            // обрабатываем событие, так как тревоги еще нет
            EventProcessor.processEvent(smartHome, event);
        }
    }
    public static boolean isSensorEvent(SensorEvent event){
        return (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED ||
                event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }
}
