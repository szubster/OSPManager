package com.miniinf.OSPManager.rest.controllers;

import com.google.common.collect.Iterables;
import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

//@Before,@BeforeClass,@After,@AfterClass

public class FireFighterControllerTest {

    @Test
    public void getAllTest() {
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        FireFighter ff2 = new FireFighter();
        ff2.setName("Tomek");
        ff2.setSurname("Szuba");
        FireFighter[] ffArray = new FireFighter[]{ff, ff2};
        when(repository.findAll()).thenReturn(Arrays.asList(ffArray));
        setField(controller, "repository", repository);
        Iterable<FireFighter> ffs = controller.getAll();
        assertArrayEquals(Iterables.toArray(ffs, FireFighter.class), ffArray);
        verify(repository, times(1)).findAll();
        verify(repository, only()).findAll();
    }

    @Test
    public void getById() {
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        setField(ff, "id", BigInteger.valueOf(10));
        FireFighter ff2 = new FireFighter();
        ff2.setName("Tomek");
        ff2.setSurname("Szuba");
        setField(ff2, "id", BigInteger.valueOf(11));
        when(repository.findOne(BigInteger.valueOf(10))).thenReturn(ff);
        when(repository.findOne(BigInteger.valueOf(11))).thenReturn(ff2);
        setField(controller, "repository", repository);
        assertEquals(controller.findById(BigInteger.valueOf(10)).getId(), BigInteger.valueOf(10));
        assertEquals(controller.findById(BigInteger.valueOf(11)).getName(), "Tomek");
    }
}
