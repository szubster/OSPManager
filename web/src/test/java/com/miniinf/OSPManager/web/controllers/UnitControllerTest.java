/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.services.UnitService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 10.01.13
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public class UnitControllerTest {
    private ArgumentCaptor argument;

    @Before
    public void before() {
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }

    @Test
    public void addCoursePostTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addCoursePost("kurs");
        verify(service).addCourse((String) argument.capture());
        assertEquals("kurs", argument.getValue());
    }

    @Test
    public void deleteCourseTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addCoursePost("kurs");
        controller.deleteCourse("kurs");
        verify(service).deleteCourse((String) argument.capture());
        assertEquals("kurs", argument.getValue());
    }

    @Test
    public void addRankPostTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addRankPost("rank");
        verify(service).addRank((String) argument.capture());
        assertEquals("rank", argument.getValue());
    }

    @Test
    public void deleteRankTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addRankPost("Rank");
        controller.deleteRank("Rank");
        verify(service).deleteRank((String) argument.capture());
        assertEquals("Rank", argument.getValue());
    }

    @Test
    public void addAwardPostTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addAwardPost("award");
        verify(service).addAwards((String) argument.capture());
        assertEquals("award", argument.getValue());
    }

    @Test
    public void deleteAwardTest() {
        UnitController controller = new UnitController();
        UnitService service = mock(UnitService.class);
        setField(controller, "unitService", service);
        controller.addAwardPost("Award");
        controller.deleteAward("Award");
        verify(service).deleteAward((String) argument.capture());
        assertEquals("Award", argument.getValue());
    }
}

