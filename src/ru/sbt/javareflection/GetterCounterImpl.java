package ru.sbt.javareflection;

import ru.sbt.javareflection.skip.annotation.Skip;

import java.lang.reflect.Method;

public class GetterCounterImpl implements GetterCounter {

    public GetterCounterImpl() {
    }

    /**
     * @param clazz класс в котором необходимо посчитать геттеры
     * @return количество методов содержащих get
     */
    @Override
    public int calcGetterCount(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        int count = 0;
        //System.out.println(clazz.getName());
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //System.out.println(method.getName() + " " + method.toString().contains("get"));
            if (method.toString().contains("get")) {
                //System.out.println(method.getName() + " " + method.toString().contains("get"));
                method.setAccessible(true);
                if (!method.isAnnotationPresent(Skip.class)) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
