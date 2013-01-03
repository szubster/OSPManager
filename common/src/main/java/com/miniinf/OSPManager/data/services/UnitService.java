/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.repositories.UnitRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UnitService implements InitializingBean {
    @Autowired
    UnitRepository repository;

    @PreAuthorize("hasRole('admin')")
    public void resetCounter() {
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(0);
        repository.save(entity);
    }

    @PreAuthorize("hasRole('admin')")
    public void incrementCounter() {
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(entity.getDepartureCounter() + 1);
        repository.save(entity);
    }

    @PreAuthorize("hasRole('admin')")
    public void setCounter(int cnt) {
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(cnt);
    }

    public int getCounter() {
        Unit entity = repository.findAll().get(0);
        return entity.getDepartureCounter();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.count() == 0) {
            Unit entity = new Unit();
            entity.setDepartureCounter(1);
            entity.setKSRGEntity("SP Mińsk");
            repository.save(entity);
        }
    }
}
