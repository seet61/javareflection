package ru.sbt.javareflection.proxy;

import ru.sbt.javareflection.GetterCounter;
import ru.sbt.javareflection.GetterCounterImpl;
import ru.sbt.javareflection.Main;
import ru.sbt.javareflection.skip.SkipData;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;

public class ProxyTest {
    public static void main(String[] args) {
        GetterCounter getterCounter = createGetterCounter();

        // Варианты проверки для разных классов
        try {
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(SkipData.class)));
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(HashMap.class)));
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(HashMap.class)));
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(ArrayList.class)));
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(SkipData.class)));
            System.out.println(String.format("count: %s", getterCounter.calcGetterCount(ArrayList.class)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создаем прокси для GetterCounter который будет выводить время работы метода
     * @return прокси для GetterCounter
     */
    private static GetterCounter createGetterCounter(){
        final GetterCounter delegate = new GetterCounterImpl();
        return (GetterCounter) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] {GetterCounter.class},
                new GetterCounterInvocationHandler(delegate));
    }
}
