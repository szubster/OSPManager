/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.InspectionEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface InspectionEquipmentRepository extends MongoRepository<InspectionEquipment, BigInteger> {
}
