package ru.sbt.javareflection;

import java.lang.reflect.Method;

public class GetterCounterImpl implements GetterCounter {

    public GetterCounterImpl() {
    }

    @Override
    public int calcGetterCount(Class<?> clazz) {
        int count = 0;

        Method[] methods = clazz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            //System.out.println(method.getName() + " " + method.toString().contains("get"));
            if (method.toString().contains("get")) {
                count += 1;
            }
        }

        return count;
    }
}
