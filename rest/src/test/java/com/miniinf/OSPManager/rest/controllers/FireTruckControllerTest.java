package com.miniinf.OSPManager.rest.controllers;

import com.google.common.collect.Iterables;
import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.repositories.FireTruckRepository;
import org.hamcrest.core.AnyOf;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 26.11.12
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class FireTruckControllerTest {

    private ArgumentCaptor argument;
    @Before
    public void before(){
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }

    public void addTest() {
        FireTruckController controller = new FireTruckController();
        FireTruckRepository repository = mock(FireTruckRepository.class);
        FireTruck ft = new FireTruck();
        ft.setLicensePlate("ABC");
        ft.setNumber("1234");
//        when(repository.save(any(FireTruck.class))).thenReturn(ft);
        FireTruck ft2 = controller.addTruck("1234","ABC");
           verify(repository).save((FireTruck) argument.capture());
           assertSame(ft,argument.getValue());

    }
}
