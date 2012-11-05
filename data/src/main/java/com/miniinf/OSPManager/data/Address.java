package com.miniinf.OSPManager.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 05.11.12
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */

public class Address {
    // ------------------------------ FIELDS ------------------------------
    private static final String STREET_PATTERN = "[A-Z][a-z]+( ([A-Z][a-z])|\\d)* \\d+";
    private static final String CITY_PATTERN = "[A-Z][a-z]+( [A-Z][a-z])*";
    private static final String POSTCODE_PATTERN = "\\d\\d-\\d\\d\\d";

    @NotNull
    @Pattern(regexp = STREET_PATTERN)
    private String street;

    @NotNull
    @Pattern(regexp = CITY_PATTERN)
    private String city;

    @NotNull
    @Pattern(regexp = POSTCODE_PATTERN)
    private String postCode;

// -------------------------- OTHER METHODS --------------------------

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
