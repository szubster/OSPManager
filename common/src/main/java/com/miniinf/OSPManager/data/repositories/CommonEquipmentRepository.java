/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.CommonEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Repository for common equipment (equipment with no need of inspection)
 */
@Repository
public interface CommonEquipmentRepository extends MongoRepository<CommonEquipment, BigInteger> {
}
