/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.repositories.FireTruckRepository;
import com.miniinf.OSPManager.data.services.FireTruckService;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 10.01.13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public class FireTruckServiceTest {
    @Test
    public void findAllTest() {
        FireTruckService service = new FireTruckService();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        setField(service, "repository", repository);
        FireTruck entity = new FireTruck();
        entity.setCodeName("123-45");
        LinkedList<FireTruck> list = new LinkedList<>();
        list.add(entity);
        when(repository.findAll()).thenReturn(list);
        assertEquals(entity, service.findAll().toArray()[0]);
    }

    @Test
    public void updateMilageTest() {
        FireTruckService service = new FireTruckService();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        setField(service, "repository", repository);
        FireTruck entity = new FireTruck();
        entity.setCodeName("123-45");
        entity.setMilage(100);
        when(repository.findOneByCodeName("123-45")).thenReturn(entity);
        service.updateMileage("123-45", 200);
        assertEquals(200, entity.getMilage());
    }
}
