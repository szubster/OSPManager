/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Michał Tkaczyk
 * Date: 05.11.12
 * Repository for Operations
 */
@Repository
public interface OperationRepository extends MongoRepository<Operation, BigInteger> {
}
