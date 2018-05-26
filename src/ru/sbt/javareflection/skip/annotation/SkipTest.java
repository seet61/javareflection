package ru.sbt.javareflection.skip.annotation;

import ru.sbt.javareflection.skip.SkipData;

import java.lang.reflect.Method;

public class SkipTest {
    public static void main(String[] args) {
        SkipData skipData = new SkipData();
        Method[] methods = skipData.getClass().getDeclaredMethods();
        for (Method method : methods) {

        }
    }
}
