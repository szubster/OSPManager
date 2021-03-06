/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.repositories.UnitRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:53
 */
@Service
public class UnitServiceImpl implements InitializingBean, UnitService {
    @Autowired
    UnitRepository repository;

    @Override
    @PreAuthorize("hasRole('admin')")
    public void resetCounter() {
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(0);
        repository.save(entity);
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void incrementCounter() {
        Unit entity = repository.findAll().get(0);
        entity.setDepartureCounter(entity.getDepartureCounter() + 1);
        repository.save(entity);
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void setCounter(int cnt) {
        Unit entity = repository.findAll().get(0);
        if (entity.getDepartureCounter() < cnt) {
            entity.setDepartureCounter(cnt);
            repository.save(entity);
        }
    }

    @Override
    public int getCounter() {
        Unit entity = repository.findAll().get(0);
        return entity.getDepartureCounter();
    }


    @Override
    @PreAuthorize("hasRole('admin')")
    public void addCourse(String course) {
        Unit entity = repository.findAll().get(0);
        entity.getCourses().add(course);
        repository.save(entity);
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void deleteCourse(String course) {
        Unit entity = repository.findAll().get(0);
        entity.getCourses().remove(course);
        repository.save(entity);
    }

    @Override
    public List<String> showCourses() {
        Unit entity = repository.findAll().get(0);
        return entity.getCourses();
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void addRank(String rank) {
        Unit entity = repository.findAll().get(0);
        entity.getRanks().add(rank);
        repository.save(entity);
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void deleteRank(String rank) {
        Unit entity = repository.findAll().get(0);
        entity.getRanks().remove(rank);
        repository.save(entity);
    }

    @Override
    public List<String> showRanks() {
        Unit entity = repository.findAll().get(0);
        return entity.getRanks();
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void addAwards(String award) {
        Unit entity = repository.findAll().get(0);
        entity.getAwards().add(award);
        repository.save(entity);

    }

    @Override
    @PreAuthorize("hasRole('admin')")
    public void deleteAward(String award) {
        Unit entity = repository.findAll().get(0);
        entity.getAwards().remove(award);
    }

    @Override
    public List<String> showAwards() {
        Unit entity = repository.findAll().get(0);
        return entity.getAwards();
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

    @Override
    public Unit getUnit() {
        return repository.findAll().get(0);
    }
}
