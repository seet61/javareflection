package ru.sbt.javareflection.proxy;

import ru.sbt.javareflection.GetterCounter;
import ru.sbt.javareflection.GetterCounterImpl;
import ru.sbt.javareflection.Main;
import ru.sbt.javareflection.skip.SkipData;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        GetterCounter getterCounter = createGetterCounter();
        System.out.println(getterCounter.getClass());

        try {
            System.out.println(getterCounter.calcGetterCount(SkipData.class));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создаем прокси для ITemplateBuilder который будет выводить время работы каждого метода
     * @return прокси для ITemplateBuilder
     */
    private static GetterCounter createGetterCounter(){
        final GetterCounter delegate = new GetterCounterImpl();
        return (GetterCounter) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] {GetterCounter.class},
                new GetterCounterInvocationHandler(delegate));
    }
}
