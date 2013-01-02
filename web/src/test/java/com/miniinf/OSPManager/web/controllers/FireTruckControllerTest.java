/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.repositories.FireTruckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 27.11.12
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class FireTruckControllerTest {
//    create,delete,update,list

    private ArgumentCaptor argument;

    @Before
    public void before() {
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }

    @Test
    public void createTest() {
        FireTruckController controller = new FireTruckController();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        FireTruck ff = new FireTruck();
        ff.setLicensePlate("ABC");
        ff.setCodeName("123-44");
        BindingResult br = mock(BindingResult.class);
        Model m = mock(Model.class);
        when(br.hasErrors()).thenReturn(true);
        setField(ff, "id", BigInteger.valueOf(10));
        setField(controller, "repository", repository);
        String result = controller.create(ff, br, m);
        assertEquals("firetruck/create", result);
    }

    @Test
    public void updateTest() {
        FireTruckController controller = new FireTruckController();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        FireTruck ff = new FireTruck();
        ff.setLicensePlate("ABC");
        ff.setCodeName("123-44");
        BindingResult br = mock(BindingResult.class);
        Model m = mock(Model.class);
        when(br.hasErrors()).thenReturn(true);
        setField(ff, "id", BigInteger.valueOf(10));
        setField(controller, "repository", repository);
        String result = controller.update(ff, br, m);
        assertEquals("firetruck/update/" + ff.getId(), result);
    }

    @Test
    public void deleteTest() {
        FireTruckController controller = new FireTruckController();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        setField(controller, "repository", repository);
        controller.delete(BigInteger.valueOf(10));
        verify(repository).delete((BigInteger) argument.capture());
        assertEquals(BigInteger.valueOf(10), argument.getValue());
    }

    @Test
    public void listTest() {
        FireTruckController controller = new FireTruckController();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        setField(controller, "repository", repository);
        controller.list(2, 1);
        verify(repository).findAll((Pageable) argument.capture());
        assertEquals(new PageRequest(1, 1), argument.getValue());
    }
}
