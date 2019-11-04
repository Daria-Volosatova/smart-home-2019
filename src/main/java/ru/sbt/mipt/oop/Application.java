package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = SmartHomeReader.read();
        EventManager.manageSmartHome(smartHome);
    }
}
