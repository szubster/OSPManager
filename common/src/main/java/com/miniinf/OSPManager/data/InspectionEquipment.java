/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
@Document
public class InspectionEquipment extends Equipment {


    @Past
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastInspectionDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date usageTime;

    @Pattern(regexp = FireTruck.CODENAME_PATTERN  , message="{com.miniinf.OSPManager.validation.codename}")
    private String truckCodeName;

    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public Date getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(Date usageTime) {
        this.usageTime = usageTime;
    }

    public String getTruckCodeName() {
        return truckCodeName;
    }

    public void setTruckCodeName(String truckCodeName) {
        this.truckCodeName = truckCodeName;
    }
}
