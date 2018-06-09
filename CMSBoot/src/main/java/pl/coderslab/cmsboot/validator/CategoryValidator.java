package pl.coderslab.cmsboot.validator;

import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Transactional
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
