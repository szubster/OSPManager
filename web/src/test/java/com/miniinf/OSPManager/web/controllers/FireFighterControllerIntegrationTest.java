package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.web.conttrollers.FireFighterController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 19.12.12
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
          /*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml"})
public class FireFighterControllerIntegrationTest {
    @Autowired
    private FireFighterController controller;

    @Autowired
    private FireFighterRepository repository;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter adapter;

    @Before
    public void setUp() throws Exception {
        this.adapter = new AnnotationMethodHandlerAdapter();
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();
    }
    @Test
    public void showTest(){
        request.setRequestURI("/firefighter/24942255819707326194205806830");
        ModelAndView mav = null;
        mav = adapter.handle(request,response,controller);
        assertEquals(response.getStatus(),200);

    }
}    */
