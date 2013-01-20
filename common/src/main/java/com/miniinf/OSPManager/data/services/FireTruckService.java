/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.FireTruck;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Paula
 * Date: 20.01.13
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public interface FireTruckService {
    void updateMileage(String codeName, int mileage);

    List<FireTruck> findAll();
}
