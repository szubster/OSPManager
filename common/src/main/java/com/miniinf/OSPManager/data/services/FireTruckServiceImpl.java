/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.repositories.FireTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz Szuba
 * Date: 05.01.13
 */
@Service
public class FireTruckServiceImpl implements FireTruckService {
    @Autowired
    FireTruckRepository repository;

    @Override
    public void updateMileage(String codeName, int mileage) {
        FireTruck fireTruck = repository.findOneByCodeName(codeName);
        if (fireTruck.getMilage() < mileage) {
            fireTruck.setMilage(mileage);
            repository.save(fireTruck);
        }
    }

    @Override
    public List<FireTruck> findAll() {
        return repository.findAll();
    }
}
