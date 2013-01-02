/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UnitService {
    @Autowired
    UnitRepository repository;

    public void resetCounter(){
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(0);
        repository.save(entity);
    }

    public void incrementCounter(){
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(entity.getDepartureCounter()+1);
        repository.save(entity);
    }

    public void setCounter(int cnt){
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(cnt);
    }

    public int getCounter(){
        Unit entity = repository.findAll().get(0);
        return entity.getDepartureCounter();
    }
}
