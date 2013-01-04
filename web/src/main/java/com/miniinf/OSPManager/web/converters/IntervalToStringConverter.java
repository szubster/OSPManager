/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.converters;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Tomasz Szuba
 * Date: 04.01.13
 */
public class IntervalToStringConverter implements Converter<Interval, String> {

    private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");

    private static final DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HH:mm");

    @Override
    public String convert(Interval source) {
        String[] ret = new String[4];
        ret[0] = source.getStart().toString(dateFormat);
        ret[1] = source.getStart().toString(timeFormat);
        ret[2] = source.getEnd().toString(dateFormat);
        ret[3] = source.getEnd().toString(timeFormat);
        return StringUtils.join(ret, ',');
    }
}
