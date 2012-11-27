package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.web.conttrollers.FireFighterController;
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
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import java.math.BigInteger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 27.11.12
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class FireFighterControllerTest {

//    create, delete, update, list
    private ArgumentCaptor argument;
    @Before
    public void before(){
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }
      @Test
       public void createTest(){
          FireFighterController controller = new FireFighterController();
          FireFighterRepository repository = mock(FireFighterRepository.class);
          FireFighter ff = new FireFighter();
          ff.setName("Michal");
          ff.setSurname("Tkaczyk");
          BindingResult br = mock(BindingResult.class);
          Model m = mock(Model.class);
          when(br.hasErrors()).thenReturn(true);
          setField(ff, "id", BigInteger.valueOf(10));
          setField(controller, "repository", repository);
          String result = controller.create(ff,br,m);
          assertEquals("firefighter/create",result);
      }

    @Test
    public void updateTest(){
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        FireFighter ff = new FireFighter();
        ff.setName("Michal");
        ff.setSurname("Tkaczyk");
        BindingResult br = mock(BindingResult.class);
        Model m = mock(Model.class);
        when(br.hasErrors()).thenReturn(true);
        setField(ff, "id", BigInteger.valueOf(10));
        setField(controller, "repository", repository);
        String result = controller.update(ff, br, m);
        assertEquals("firefighter/update/" + ff.getId(),result);
    }

    @Test
    public void deleteTest(){
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        setField(controller, "repository", repository);
        controller.delete(BigInteger.valueOf(10));
        verify(repository).delete((BigInteger) argument.capture());
        assertEquals(BigInteger.valueOf(10),argument.getValue());
    }

    @Test
    public void listTest(){
        FireFighterController controller = new FireFighterController();
        FireFighterRepository repository = mock(FireFighterRepository.class);
        setField(controller, "repository", repository);
        controller.list(2,1);
        verify(repository).findAll((Pageable) argument.capture());
        assertEquals(new PageRequest(1, 1), argument.getValue());
    }
}
