package ru.sbt.javareflection.skip;

import ru.sbt.javareflection.skip.annotation.Skip;

/**
 * Тестовый класс, на основании которого будет производиться первоначальная проверка
 */
public class SkipData {
    private String info = "info";

    public SkipData() {
    }

    @Skip
    public String getClassName() {
        return this.getClass().getName();
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "SkipData{}";
    }
}
