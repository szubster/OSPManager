/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Class for equipment that needs inspections from time to time
 */
@Document
public class InspectionEquipment extends Equipment {


    @Past
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastInspectionDate;

    @Pattern(regexp = FireTruck.CODENAME_PATTERN, message = "{com.miniinf.OSPManager.validation.codename}")
    private String truckCodeName;

    /**
     * Returns when the last inspections occurs
     *
     * @return InspectionEquipment's last inspection date
     */
    public LocalDate getLastInspectionDate() {
        return lastInspectionDate;
    }

    /**
     * Setter for InspectionEquipment's last inspection date
     *
     * @param lastInspectionDate InspectionEquipment's last inspection date
     */
    public void setLastInspectionDate(LocalDate lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    /**
     * Returns codename of the truck to which item is assigned
     *
     * @return Assigned truck codename
     */
    public String getTruckCodeName() {
        return truckCodeName;
    }

    /**
     * Sets the truck to which item is assigned
     *
     * @param truckCodeName InspectionEquipment's assigned truck
     */
    public void setTruckCodeName(String truckCodeName) {
        this.truckCodeName = truckCodeName;
    }
}
