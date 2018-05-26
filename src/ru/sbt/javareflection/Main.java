package ru.sbt.javareflection;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        GetterCounterImpl getter = new GetterCounterImpl();

        System.out.println(getter.calcGetterCount(ArrayList.class));
    }
}
