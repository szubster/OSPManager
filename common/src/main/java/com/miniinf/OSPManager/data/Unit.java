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
    protected BigInteger id;

    @Min(0)
    private int departureCounter;

    private String KSRGEntity;

    private List<String> courses = new ArrayList<>();

    private List<String> ranks = new ArrayList<>();

    private List<String> awards = new ArrayList<>();

    /**
     * Returns OSP Unit id in database
     *
     * @return
     */
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * Returns name of the KSRG
     *
     * @return Unit's KSRG name
     */
    public String getKSRGEntity() {
        return KSRGEntity;
    }

    /**
     * Sets Unit's KSRG name
     *
     * @param KSRGEntity Unit's KSRG name
     */
    public void setKSRGEntity(String KSRGEntity) {
        this.KSRGEntity = KSRGEntity;
    }

    /**
     * Returns number of last operation
     *
     * @return Unit's last operation number
     */
    public int getDepartureCounter() {
        return departureCounter;
    }

    /**
     * Sets number of last operation (does not change operation number, only field in unit class)
     *
     * @param departureCounter Unit's last operation number
     */
    public void setDepartureCounter(int departureCounter) {
        this.departureCounter = departureCounter;
    }

    /**
     * Returns list of courses available in OSP Unit
     *
     * @return Unit's courses
     */
    public List<String> getCourses() {
        return courses;
    }

    /**
     * Sets Unit's courses
     *
     * @param courses Unit's courses
     */
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    /**
     * Returns the list of the ranks available in OSP Unit
     *
     * @return Unit's ranks
     */
    public List<String> getRanks() {
        return ranks;
    }

    /**
     * Sets Unit's ranks
     *
     * @param ranks Unit's ranks
     */
    public void setRanks(List<String> ranks) {
        this.ranks = ranks;
    }

    /**
     * Returns the list of awards available in OSP unit
     *
     * @return Unit's awards
     */
    public List<String> getAwards() {
        return awards;
    }

    /**
     * Sets Unit's awards
     *
     * @param awards Unit's awards
     */
    public void setAwards(List<String> awards) {
        this.awards = awards;
    }
}
