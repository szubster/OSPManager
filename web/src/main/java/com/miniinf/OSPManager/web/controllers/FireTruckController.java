/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.FireTruck;
import com.miniinf.OSPManager.data.repositories.FireTruckRepository;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 21.11.12
 */
@Controller
@RequestMapping("firetruck")
@ReportPath("/firetruck/")
public class FireTruckController extends AbstractController<FireTruckRepository, FireTruck, BigInteger> {

    @Autowired
    FireTruckRepository repository;

    public FireTruckController() {
        super(FireTruck.class);
    }

    @Override
    protected FireTruckRepository getRepository() {
        return repository;
    }
}
