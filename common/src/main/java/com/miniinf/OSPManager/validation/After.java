/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation used for JSR-303 to express Constraint that date in one field has to be after
 * date in another field.
 * <p/>
 * Created by Tomasz Szuba
 * Date: 02.01.13
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AfterValidator.class)
@Documented
public @interface After {

    String message() default "{com.miniinf.OSPManager.validation.After}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Field name that is prior to field returned by to
     *
     * @return field name
     */
    String from();

    /**
     * Field name that is after field returned by from
     *
     * @return field name
     */
    String to();
}
