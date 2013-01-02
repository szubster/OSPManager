/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
@Document
public class Unit implements BigIntegerEntity, Serializable {

    @Id
    private BigInteger id;

    @Min(0)
    private int departureCounter;

    private String KSRGEntity;

    public BigInteger getId() {
        return id;
    }

    public String getKSRGEntity() {
        return KSRGEntity;
    }

    public void setKSRGEntity(String KSRGEntity) {
        this.KSRGEntity = KSRGEntity;
    }


    public int getDepartureCounter() {
        return departureCounter;
    }

    public void setDepartureCounter(int departureCounter) {
        this.departureCounter = departureCounter;
    }

}
