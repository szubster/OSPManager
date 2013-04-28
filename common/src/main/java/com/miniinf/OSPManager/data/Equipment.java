/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Abstract class for equipment, contains some of fields that are in common with common and inspection equipment
 */
public abstract class Equipment implements BigIntegerEntity, Serializable {

    @Id
    protected BigInteger id;

    @NotNull
    private String kind;

    private String brand;

    private String type;

    /**
     * Returns id
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
     * Returns what kind of equipment it is
     *
     * @return
     */
    public String getKind() {
        return kind;
    }

    /**
     * Setter for the kind field
     *
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Returns the brand (mark) of the item
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand for the item
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Returns what type of item it is
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type field
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}

