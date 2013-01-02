/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Tomasz Szuba
 * Date: 02.01.13
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PESELValidator.class)
@Documented
public @interface PESEL {

    String message() default "{com.miniinf.OSPManager.validation.PESEL}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
