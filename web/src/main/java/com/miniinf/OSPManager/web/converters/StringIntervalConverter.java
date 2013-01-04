/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.converters;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Tomasz Szuba
 * Date: 03.01.13
 */
public class StringIntervalConverter implements Converter<String[], Interval> {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Interval convert(String[] source) {
        if (source.length != 4) {
            throw new IllegalStateException();
        }
        DateTime start = DateTime.parse(source[0] + source[1], formatter);
        DateTime end = DateTime.parse(source[2] + source[3], formatter);
        return new Interval(start, end);
    }
}
