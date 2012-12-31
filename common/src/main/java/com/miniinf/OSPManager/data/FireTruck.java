/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 05.11.12
 */
@Document
public class FireTruck implements BigIntegerEntity {

    @Id
    private BigInteger id;

    private String number;

    private String licensePlate;

    public BigInteger getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
