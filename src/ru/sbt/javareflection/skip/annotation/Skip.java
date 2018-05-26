package ru.sbt.javareflection.skip.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Пустая аннотация, для пометки класа
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Skip {
}
