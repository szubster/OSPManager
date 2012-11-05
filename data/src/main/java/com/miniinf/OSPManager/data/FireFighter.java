package com.miniinf.OSPManager.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Document
public class FireFighter {

    @Id
    BigInteger id;

    @NotNull
    @Size(min = 3)
    @Pattern(regexp = "[A-Z][a-z]*")
    String name;

    @NotNull
    @Size(min = 3)
    @Pattern(regexp = "[A-Z][a-z]*")
    String surname;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date birthDate;

    public BigInteger getId() {
        return id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
