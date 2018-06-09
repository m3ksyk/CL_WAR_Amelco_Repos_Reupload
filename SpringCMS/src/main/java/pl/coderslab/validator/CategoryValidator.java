package pl.coderslab.validator;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;

public class CategoryValidator implements ConstraintValidator<CategoryNumber, Integer> {
    private int number;

    @Override
    public void initialize(CategoryNumber constraintAnnotation) {
//        this.number = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return i <= number;
    }


}
