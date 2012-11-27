package com.miniinf.OSPManager.rest.controllers;

import com.google.common.collect.Iterables;
import com.miniinf.OSPManager.data.Address;
import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.Operation.FireFighter;
import com.miniinf.OSPManager.data.Operation;
import com.miniinf.OSPManager.data.repositories.OperationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.math.BigInteger;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 27.11.12
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class OperationControllerTest {

//    getall, add, delete, update

    private Operation createOperation(String city, BigInteger id, String name, String surname, String number, String plate){
        Address ad = new Address(); ad.setCity(city);
        FireFighter ff = new FireFighter(); ff.setId(id); ff.setName(name); ff.setSurname(surname);
        FireTruck ft = new FireTruck(); ft.setNumber(number); ft.setLicensePlate(plate);
        Operation op = new Operation(); op.setPlace(ad); op.setParticipants(Arrays.asList(new FireFighter[]{ff}));
        op.setTruck(Arrays.asList(new FireTruck[]{ft}));
        return op;
    }
    @Test
    public void getAllTest(){
        OperationRepository repository = mock(OperationRepository.class);
        OperationController controller = new OperationController();
        Operation op1 = createOperation("Parczew",BigInteger.valueOf(10),"Michal","Tkaczyk","1234","ABCD");
        Operation op2 = createOperation("Parczew",BigInteger.valueOf(10),"Tomek","Szuba","1234","ABCD");
        when(repository.findAll()).thenReturn(Arrays.asList(new Operation[]{op1, op2}))    ;
        setField(controller, "operationRepository", repository);
        Iterable<Operation> ops = controller.getAll();
        assertArrayEquals(Iterables.toArray(ops, Operation.class), new Operation[]{op1, op2});
        verify(repository, times(1)).findAll();
        verify(repository, only()).findAll();
    }
        @Test
        public void addTest() {
        OperationRepository repository = mock(OperationRepository.class);
        OperationController controller = new OperationController();
        Operation op1 = createOperation("Parczew",BigInteger.valueOf(10),"Michal","Tkaczyk","1234","ABCD");
        setField(controller, "operationRepository", repository);
        controller.add(op1);
        verify(repository, only()).save(op1)  ;
    }

    @Test
    public void deleteTest(){

        OperationRepository repository = mock(OperationRepository.class);
        OperationController controller = new OperationController();
        Operation op1 = createOperation("Parczew",BigInteger.valueOf(10),"Michal","Tkaczyk","1234","ABCD");
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return "Delete succeeded";
            }
        }).when(repository).delete(op1);
        setField(op1, "id", BigInteger.valueOf(10));
        setField(controller, "operationRepository", repository);
        String ss = controller.delete(BigInteger.valueOf(10));
        Assert.assertEquals("Delete succeeded", ss);
        verify(repository).delete((BigInteger) argument.capture());
        Assert.assertEquals(BigInteger.valueOf(10), argument.getValue());
    }

    private ArgumentCaptor argument;
    @Before
    public void before(){
        argument = ArgumentCaptor.forClass(BigInteger.class);
    }

    @Test
    public void updateTest() {
        OperationRepository repository = mock(OperationRepository.class);
        OperationController controller = new OperationController();
        Operation op1 = createOperation("Parczew",BigInteger.valueOf(10),"Michal","Tkaczyk","1234","ABCD");
        setField(op1, "id", BigInteger.valueOf(10));
        when(repository.findOne(BigInteger.valueOf(10))).thenReturn(op1);
        when(repository.save(op1)).thenReturn(op1);
        setField(controller, "operationRepository", repository);
        Address ad = new Address(); ad.setCity("Warszawa");
        Operation op2 = controller.update(BigInteger.valueOf(10),ad,null);
        assertEquals(op1.getId(),op2.getId());
        assertEquals("Warszawa",op2.getPlace().getCity());
    }
}
