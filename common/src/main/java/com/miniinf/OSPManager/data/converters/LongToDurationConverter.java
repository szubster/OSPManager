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
public class LongToDurationConverter implements Converter<Long, Duration> {
    @Override
    public Duration convert(Long aLong) {
        return new Duration(aLong);
    }
}
