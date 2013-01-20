/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 10.01.13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */


import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.repositories.UnitRepository;
import com.miniinf.OSPManager.data.services.UnitService;
import com.miniinf.OSPManager.data.services.UnitServiceImpl;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;


public class UnitServiceTest {


    @Test
    public void resetCounterTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        entity.setDepartureCounter(10);
        assertEquals(10, entity.getDepartureCounter());
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.resetCounter();
        assertEquals(0, entity.getDepartureCounter());
    }

    @Test
    public void incrementCounterTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        entity.setDepartureCounter(10);
        assertEquals(10, entity.getDepartureCounter());
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.incrementCounter();
        assertEquals(11, entity.getDepartureCounter());
    }

    @Test
    public void setCounterTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        entity.setDepartureCounter(10);
        assertEquals(10, entity.getDepartureCounter());
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.setCounter(11);
        assertEquals(11, entity.getDepartureCounter());
    }

    @Test
    public void addCourseTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addCourse("kurs");
        assertEquals("kurs", entity.getCourses().toArray()[0]);
    }

    @Test
    public void deleteCourseTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addCourse("kurs");
        service.addCourse("course");
        service.deleteCourse("kurs");
        assertEquals("course", entity.getCourses().toArray()[0]);
    }

    @Test
    public void addAwardTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addAwards("kurs");
        assertEquals("kurs", entity.getAwards().toArray()[0]);
    }

    @Test
    public void deleteAwardTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addAwards("Award");
        service.addAwards("nagroda");
        service.deleteAward("Award");
        assertEquals("nagroda", entity.getAwards().toArray()[0]);
    }

    @Test
    public void addRankTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addRank("Rank");
        assertEquals("Rank", entity.getRanks().toArray()[0]);
    }

    @Test
    public void deleteRankTest() {
        UnitService service = new UnitServiceImpl();
        UnitRepository repository = mock(UnitRepository.class);
        setField(service, "repository", repository);
        Unit entity = new Unit();
        LinkedList<Unit> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        service.addRank("rank");
        service.addRank("ranga");
        service.deleteRank("rank");
        assertEquals("ranga", entity.getRanks().toArray()[0]);
    }

}

