package ru.sbt.javareflection.proxy;

import ru.sbt.javareflection.GetterCounter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GetterCounterInvocationHandler implements InvocationHandler {
    private GetterCounter delegate;
    private Map<String, Integer> cache = new HashMap<>();

    public GetterCounterInvocationHandler(GetterCounter delegate) {
        this.delegate = delegate;
    }

    /**
     * Здесь мы можем перехватить вызов метода проксируемого интерфейса
     * Подменить или дополнить поведение этого метода
     * или делигировать вызов
     *
     * @param proxy  - Объект метод которого был вызван
     * @param method Метод который был вызван
     * @param args   Параметры метода
     * @return Результат работы метода
     * @throws Throwable Исключение которое может быть выбрашено
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Время запуска
        final long start = System.currentTimeMillis();
        // Ключ для мапы
        String className = args[0].toString().split(" ")[1];
        // Проверяем, есть ли уже значение
        if (cache.containsKey(className)) {
            System.out.println(String.format("Proxy: Method %s with arg %s finished %s ms.",
                    method.getName(), className, String.valueOf(System.currentTimeMillis() - start)));
            return cache.get(className);
        }
        // Если нет
        int count = (int) method.invoke(delegate, args);
        cache.put(className, count);
        System.out.println(String.format("Proxy: Method %s with arg %s finished %s ms.",
                method.getName(), className, String.valueOf(System.currentTimeMillis() - start)));
        return count;
    }
}
