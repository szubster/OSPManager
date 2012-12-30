/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 05.11.12
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */

@Document
public class Operation implements BigIntegerEntity {
// -------------------------- INNER CLASSES --------------------------

    public static class FireFighter {

        private BigInteger id;
        private String name;
        private String surname;

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
    }

    @Id
    private BigInteger id;

    @Valid
    private Address place;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    List<FireFighter> participants;

    @DBRef
    @Valid
    List<FireTruck> truck;

    public BigInteger getId() {
        return id;
    }

    public Address getPlace() {
        return place;
    }

    public void setPlace(Address place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<FireFighter> getParticipants() {
        return participants;
    }

    public void setParticipants(List<FireFighter> participants) {
        this.participants = participants;
    }


    public List<FireTruck> getTruck() {
        return truck;
    }

    public void setTruck(List<FireTruck> truck) {
        this.truck = truck;
    }
}
