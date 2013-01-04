/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by Tomasz Szuba
 * Date: 05.11.12
 * Class describing whole address - street, city and postcode
 */
public class Address implements Serializable {

    private static final String STREET_PATTERN = "(\\p{Lu}\\p{Ll}*|\\d+) ((\\p{Lu}\\p{Ll}*|\\d+) )*\\d+";

    private static final String CITY_PATTERN = "\\p{Lu}\\p{Ll}*( (\\p{Lu}\\p{Ll}*|\\d+))*";

    private static final String POSTCODE_PATTERN = "\\d\\d-\\d\\d\\d";

    @NotNull
    @Pattern(regexp = STREET_PATTERN, message = "{com.miniinf.OSPManager.validation.street}")
    private String street;

    @NotNull
    @Pattern(regexp = CITY_PATTERN, message = "{com.miniinf.OSPManager.validation.city}")
    private String city;

    @Pattern(regexp = POSTCODE_PATTERN, message = "{com.miniinf.OSPManager.validation.postcode}")
    private String postCode;

    /**
     * Returns City name
     *
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for field City
     *
     * @param city name of the City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns postcode
     *
     * @return postcode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Setter for the postcode
     *
     * @param postCode postcode number
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Returns street name
     *
     * @return street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for street name
     *
     * @param street street name
     */
    public void setStreet(String street) {
        this.street = street;
    }
}
