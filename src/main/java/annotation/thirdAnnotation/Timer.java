package annotation.thirdAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
// @Inherited
public @interface Timer {

}
