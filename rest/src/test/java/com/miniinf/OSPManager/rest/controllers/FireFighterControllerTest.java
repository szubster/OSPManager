package com.miniinf.OSPManager.rest.controllers;

import com.google.common.collect.Iterables;
import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

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
    public void getByIdTest() {
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

    @Test
    public void getTest() {
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        setField(ff, "id", BigInteger.valueOf(10));
        FireFighter ff2 = new FireFighter();
        ff2.setName("Tomek");
        ff2.setSurname("Szuba");
        ff2.setBirthDate(new Date(1234));
        setField(ff2, "id", BigInteger.valueOf(11));
        when(repository.findByNameAndSurname("Michal", "Tkaczyk")).thenReturn(Arrays.asList(new FireFighter[]{ff}));
        when(repository.findByName("Tomek")).thenReturn(Arrays.asList(new FireFighter[]{ff2}))   ;
        when(repository.findByBirthDate(new Date(1234))).thenReturn(Arrays.asList(new FireFighter[]{ff2}));
        setField(controller, "repository", repository);
        assertEquals(controller.get("Michal","Tkaczyk",null).iterator().next().getId(),BigInteger.valueOf(10));
        assertEquals(controller.get("Tomek",null,null).iterator().next().getId(),BigInteger.valueOf(11));
        assertEquals(controller.get(null, null, new Date(1234)).iterator().next().getName(), "Tomek");
    }
      @Test
     public void updateTest() {
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        setField(ff, "id", BigInteger.valueOf(10));
        when(repository.findOne(BigInteger.valueOf(10))).thenReturn(ff);
        when(repository.save(ff)).thenReturn(ff);
        setField(controller, "repository", repository);
        FireFighter ff2 = controller.update(BigInteger.valueOf(10),"Tomek","Szuba",null);
        assertEquals(ff.getId(),ff2.getId());
        assertEquals("Tomek",ff2.getName());
        assertEquals("Szuba",ff2.getSurname());
    }

    @Test
    public void addTest() {
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        setField(ff, "id", BigInteger.valueOf(10));
        when(repository.save(any(FireFighter.class))).thenReturn(ff);
        setField(controller, "repository", repository);
       FireFighter ff2 = controller.add("Michal","Tkaczyk",null);
        assertEquals(ff.getName(),ff2.getName());
        assertEquals(ff.getSurname(),ff2.getSurname());
    }

    @Test
    public void deleteTest(){

        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        setField(ff, "id", BigInteger.valueOf(10));
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return "Delete succeeded";
            }
        }).when(repository).delete(ff);
        setField(controller, "repository", repository);
        String ss = controller.delete(BigInteger.valueOf(10));
        assertEquals("Delete succeeded",ss);
        verify(repository).delete((BigInteger) argument.capture());
        assertEquals(BigInteger.valueOf(10),argument.getValue());
    }

    private ArgumentCaptor argument;
    @Before
    public void before(){
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }

}
