package AnnotationsAndExceptions.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataValidation {
//    DataType type();
    int minLength() default 0;
    int maxLength() default Integer.MAX_VALUE;
    double minValue() default Double.MIN_VALUE;
    double maxValue() default Double.MAX_VALUE;
    String regex() default "";
}