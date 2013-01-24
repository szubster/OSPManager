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
public class DurationToStringConverter implements Converter<Duration, String> {

    PeriodFormatter formatter =
            new PeriodFormatterBuilder().appendHours().appendSeparator(":").appendMinutes().toFormatter();

    @Override
    public String convert(Duration source) {
        return formatter.print(source.toPeriod());
    }
}
