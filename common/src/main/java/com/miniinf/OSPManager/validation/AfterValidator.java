/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Tomasz Szuba
 * Date: 02.01.13
 */
public class AfterValidator implements ConstraintValidator<After, Object> {
    private String from;

    private String to;


    @Override
    public void initialize(After constraintAnnotation) {
        from = constraintAnnotation.from();
        to = constraintAnnotation.to();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return true;
    }
}
