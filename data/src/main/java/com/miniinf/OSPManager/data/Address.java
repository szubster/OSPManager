package com.miniinf.OSPManager.data;

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

    private String Street;

    private String City;

    @Pattern(regexp = "\\d\\d\\d-\\d\\d")
    private String PostCode;

// -------------------------- OTHER METHODS --------------------------

    public String getCity() {
        return City;
    }

    public String getPostCode() {
        return PostCode;
    }

    public String getStreet() {
        return Street;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public void setStreet(String street) {
        Street = street;
    }
}
