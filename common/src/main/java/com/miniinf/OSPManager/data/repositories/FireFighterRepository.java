/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.FireFighter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 15.10.12
 */
@Repository
public interface FireFighterRepository extends MongoRepository<FireFighter, BigInteger> {
}
