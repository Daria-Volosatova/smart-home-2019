package ru.sbt.mipt.oop;

public class Application {

    public static void main(String... args){
        // считываем состояние дома из файла
        SmartHomeReader reader = new SmartHomeReader();
        SmartHome smartHome = reader.read("smart-home-1.js");
        EventManager.manageSmartHome(smartHome);
    }
}
