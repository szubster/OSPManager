/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomasz Szuba
 * Date: 05.11.12
 */
@Document
public class Operation implements BigIntegerEntity, Serializable {


    @Id
    private BigInteger id;

    @Valid
    private Address place;

    @Min(0)
    private int number;

    private String owner;

    private String interventionType;

    private String victim;

    private String[] cooperatingUnits;

    private Map<String,Integer> means;

    private String declarant;

    private String description;

    private int nrPSP;

    private String author;

    @NotNull
    @Pattern(regexp = FireTruck.CODENAME_PATTERN  , message="{com.miniinf.OSPManager.validation.codename}")
    private String truckCodeName;

    @Min(0)
    private int mileageStart;

    private int mileageEnd;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date departureDateTime;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date arrivalDateTime;

    private List<FireFighter> participants;

    public BigInteger getId() {
        return id;
    }

    public Address getPlace() {
        return place;
    }

    public void setPlace(Address place) {
        this.place = place;
    }

    public List<FireFighter> getParticipants() {
        return participants;
    }

    public void setParticipants(List<FireFighter> participants) {
        this.participants = participants;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getInterventionType() {
        return interventionType;
    }

    public void setInterventionType(String interventionType) {
        this.interventionType = interventionType;
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public String[] getCooperatingUnits() {
        return cooperatingUnits;
    }

    public void setCooperatingUnits(String[] cooperatingUnits) {
        this.cooperatingUnits = cooperatingUnits;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDeclarant() {
        return declarant;
    }

    public void setDeclarant(String declarant) {
        this.declarant = declarant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNrPSP() {
        return nrPSP;
    }

    public void setNrPSP(int nrPSP) {
        this.nrPSP = nrPSP;
    }

    public String getTruckCodeName() {
        return truckCodeName;
    }

    public void setTruckCodeName(String truckCodeName) {
        this.truckCodeName = truckCodeName;
    }

    public int getMileageStart() {
        return mileageStart;
    }

    public void setMileageStart(int mileageStart) {
        this.mileageStart = mileageStart;
    }

    public int getMileageEnd() {
        return mileageEnd;
    }

    public void setMileageEnd(int mileageEnd) {
        this.mileageEnd = mileageEnd;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Map<String, Integer> getMeans() {
        return means;
    }

    public void setMeans(Map<String, Integer> means) {
        this.means = means;
    }

    public static class FireFighter implements Serializable {

        private BigInteger id;

        private String name;

        private String surname;

        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        private Date operatingTime;

        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        private Date paidTime;

        public BigInteger getId() {
            return id;
        }

        public void setId(BigInteger id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Date getOperatingTime() {
            return operatingTime;
        }

        public void setOperatingTime(Date operatingTime) {
            this.operatingTime = operatingTime;
        }

        public Date getPaidTime() {
            return paidTime;
        }

        public void setPaidTime(Date paidTime) {
            this.paidTime = paidTime;
        }
    }
}
