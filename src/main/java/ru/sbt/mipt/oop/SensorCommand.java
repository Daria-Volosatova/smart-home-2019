package ru.sbt.mipt.oop;

public class SensorCommand {
    private final SensorCommandType type;
    private final String objectId;

    public SensorCommand(SensorCommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public String toString() {
        return "CommandSensor{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
