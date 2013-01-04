/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    private List<String> courses = new ArrayList<>();

    private List<String> ranks = new ArrayList<>();

    private List<String> awards = new ArrayList<>();

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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public List<String> getRanks() {
        return ranks;
    }

    public void setRanks(List<String> ranks) {
        this.ranks = ranks;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }
}
