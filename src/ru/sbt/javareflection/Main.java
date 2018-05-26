package ru.sbt.javareflection;

import ru.sbt.javareflection.skip.SkipData;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        GetterCounterImpl getter = new GetterCounterImpl();

        try {
            System.out.println(getter.calcGetterCount(SkipData.class));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
