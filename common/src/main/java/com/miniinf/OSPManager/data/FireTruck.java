/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
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
 */
@Document
public class FireTruck implements BigIntegerEntity {

    private static final String CODENAME_PATTERN = "\\d\\d\\d-\\d\\d";

    @Id
    private BigInteger id;

    private String licensePlate;

    @Min(0)
    private int milage;

    @NotNull
    @Pattern(regexp = CODENAME_PATTERN  , message="{com.miniinf.OSPManager.validation.codename}")
    private String codeName;

    public BigInteger getId() {
        return id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String number) {
        this.codeName = number;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMilage(int milage){
        this.milage = milage;
    }
    public int getMilage(){
        return this.milage;
    }
}
