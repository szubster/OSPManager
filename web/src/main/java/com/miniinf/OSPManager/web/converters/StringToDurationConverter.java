/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.converters;

import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Tomasz Szuba
 * Date: 24.01.13
 */
public class StringToDurationConverter implements Converter<String, Duration> {

    PeriodFormatter formatter =
            new PeriodFormatterBuilder().appendHours().appendSeparator(":").appendMinutes().toFormatter();

    @Override
    public Duration convert(String source) {
        if (source.startsWith("T")) {
            source = source.substring(1);
        }
        if (source.matches("\\d+:\\d+:\\d+")) {
            source = source.substring(0, source.lastIndexOf(':'));
        }
        return formatter.parsePeriod(source).toStandardDuration();
    }
}
