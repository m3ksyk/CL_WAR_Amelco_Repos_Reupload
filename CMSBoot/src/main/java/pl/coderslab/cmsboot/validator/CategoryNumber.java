package pl.coderslab.cmsboot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoryValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryNumber {
    String message() default "{pl.pl.coderslab.cmsboot.validator.CategoryNumber.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
