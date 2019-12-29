package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public interface EventProcessor {
    void processEvent(SensorEvent event);
}
