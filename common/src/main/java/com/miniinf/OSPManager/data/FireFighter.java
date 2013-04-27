/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import com.miniinf.OSPManager.validation.PESEL;
import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

/**
 * Class that describes FireFighter
 */
@Document
public class FireFighter implements BigIntegerEntity {

    private static final String NAME_PATTERN = "\\p{Lu}\\p{Ll}*";

    private static final String SECOND_NAME_PATTERN = "(\\p{Lu}\\p{Ll}*)|";

    private static final String LEGITIMATION_PATTERN = "\\d+/\\d{4}";

    @Id
    private BigInteger id;

    @NotNull
    @Size(min = 3)
    @Pattern(regexp = NAME_PATTERN, message = "{com.miniinf.OSPManager.validation.name}")
    private String name;

    @Pattern(regexp = SECOND_NAME_PATTERN, message = "{com.miniinf.OSPManager.validation.name}")
    private String secondName;

    @NotNull
    @Size(min = 3)
    @Pattern(regexp = NAME_PATTERN, message = "{com.miniinf.OSPManager.validation.name}")
    private String surname;

    @Past
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @Valid
    private Address address = new Address();

    @PESEL
    private String pesel;

    @Pattern(regexp = LEGITIMATION_PATTERN, message = "{com.miniinf.OSPManager.validation.legitimation}")
    private String legitimation;

    private String rank;

    private List<String> awards;

    /**
     * Returns id of firefighter in database
     *
     * @return
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Returns address of the firefighter
     *
     * @return Firefighter's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the firefighter
     *
     * @param address Firefighter's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Return name of the firefighter
     *
     * @return Firefighter's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the firefighter
     *
     * @param name Firefighter's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns surname of the firefighter
     *
     * @return Firefighter's name
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname of firefighter
     *
     * @param surname Firefighter's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns when the firefighter was born
     *
     * @return Firefighter's birthdate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birthdate for firefighter
     *
     * @param birthDate Firefighter's birthdate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns second name of firefighter
     *
     * @return Firefighter's second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets second name of firefighter
     *
     * @param secondName Firefighter's second name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Returns both: name and surname of firefighter
     *
     * @return Firefighter's name and surname
     */
    public String getNameAndSurname() {
        return name + " " + surname;
    }

    /**
     * Returns pesel of the firefighter
     *
     * @return Firefighter's pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * Sets the pesel for firefighter
     *
     * @param pesel Firefighter's pesel
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * Returns legitimation number of firefighter
     *
     * @return Firefighter's legitimation number
     */
    public String getLegitimation() {
        return legitimation;
    }

    /**
     * Sets legitimation number for firefighter
     *
     * @param legitimation Firefighter's legitimation number
     */
    public void setLegitimation(String legitimation) {
        this.legitimation = legitimation;
    }

    /**
     * Returns rank of firefighter
     *
     * @return Firefighter's rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets rank for firefighter
     *
     * @param rank Firefighter's  rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Returns list of awards that firefighter has
     *
     * @return Firefighter's awards
     */
    public List<String> getAwards() {
        return awards;
    }

    public String getStringAwards() {
        return StringUtils.join(awards, ", ");
    }

    /**
     * Sets te list of firefighter awards
     *
     * @param awards Firefighter's awards
     */
    public void setAwards(List<String> awards) {
        this.awards = awards;
    }
}
