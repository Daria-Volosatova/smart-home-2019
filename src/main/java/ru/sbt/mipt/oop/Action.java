package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.objects.Actionable;

public interface Action {
    boolean execute(Actionable actionable);
}
