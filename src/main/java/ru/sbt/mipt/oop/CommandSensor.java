package ru.sbt.mipt.oop;

public class CommandSensor {
    private final CommandType type;
    private final String objectId;

    public CommandSensor(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "CommandSensor{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
