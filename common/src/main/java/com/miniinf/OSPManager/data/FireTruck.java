/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 05.11.12
 * Class that describes FireTruck
 */
@Document
public class FireTruck implements BigIntegerEntity {

    public static final String CODENAME_PATTERN = "\\d\\d\\d-\\d\\d";

    @Id
    protected BigInteger id;

    private String licensePlate;

    @Min(0)
    private int milage;

    @NotNull
    @Pattern(regexp = CODENAME_PATTERN, message = "{com.miniinf.OSPManager.validation.codename}")
    private String codeName;

    /**
     * Return id of the firetruck in database
     *
     * @return FireTruck's ID
     */
    public BigInteger getId() {
        return id;
    }


    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * Returns FireTruck's codename (cryptonim of the truck)
     *
     * @return FireTruck's codename
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * Sets FireTruck's codename
     *
     * @param number FireTruck's codename
     */
    public void setCodeName(String number) {
        this.codeName = number;
    }

    /**
     * Returns FireTruck's license plate
     *
     * @return FireTruck's license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets FireTruck's license plate
     *
     * @param licensePlate FireTruck's license plate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Sets FireTruck's mileage
     *
     * @param milage FireTruck's mileage
     */
    public void setMilage(int milage) {
        this.milage = milage;
    }

    /**
     * Returns state of the mileage of the firetruck
     *
     * @return FireTruck's mileage
     */
    public int getMilage() {
        return this.milage;
    }
}
