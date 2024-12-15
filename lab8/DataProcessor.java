package lab8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //  жизненный цикл аннотации: в процессе выполнения.
@Target(ElementType.METHOD) // что именно мы можем пометить этой аннотацией: метод
public @interface DataProcessor {
    String value() default "";
}
