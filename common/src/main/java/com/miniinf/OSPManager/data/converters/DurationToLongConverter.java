/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.converters;

import org.joda.time.Duration;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Tomasz Szuba
 * Date: 27.01.13
 */
public class DurationToLongConverter implements Converter<Duration, Long> {
    @Override
    public Long convert(Duration duration) {
        return duration.getMillis();
    }
}
