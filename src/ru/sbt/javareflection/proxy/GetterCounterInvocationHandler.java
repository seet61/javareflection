package ru.sbt.javareflection.proxy;

import ru.sbt.javareflection.GetterCounter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GetterCounterInvocationHandler implements InvocationHandler{
    private GetterCounter delegate;

    public GetterCounterInvocationHandler(GetterCounter delegate) {
        this.delegate = delegate;
    }

    /**
     * Здесь мы можем перехватить вызов метода проксируемого интерфейса
     * Подменить или дополнить поведение этого метода
     * или делигировать вызов
     *
     * @param proxy - Объект метод которого был вызван
     * @param method Метод который был вызван
     * @param args Параметры метода
     * @return Результат работы метода
     * @throws Throwable Исключение которое может быть выбрашено
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String m = method.getName();
        System.out.println(String.format("Proxy: Method with name %s",
                m));
        return m;
    }
}
