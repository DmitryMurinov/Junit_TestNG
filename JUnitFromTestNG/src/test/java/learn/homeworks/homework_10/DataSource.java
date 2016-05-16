package learn.homeworks.homework_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    public enum Type {
        GENERATE,
        FILE
    }

    String value();
    Type type();

}