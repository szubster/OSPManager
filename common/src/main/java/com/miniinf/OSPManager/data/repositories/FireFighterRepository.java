/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.FireFighter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Tomasz Szuba
 * Date: 15.10.12
 */
@Repository
public interface FireFighterRepository extends MongoRepository<FireFighter, BigInteger> {
    Iterable<FireFighter> findByName(String Name);

    Iterable<FireFighter> findBySurname(String Surname);

    Iterable<FireFighter> findByBirthDate(Date Birthdate);

    Iterable<FireFighter> findByNameAndSurname(String Name, String Surname);
}
