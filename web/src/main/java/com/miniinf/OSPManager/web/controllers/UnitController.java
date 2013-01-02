/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.repositories.UnitRepository;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("unit")
@ReportPath("/unit/")
public class UnitController extends AbstractController<UnitRepository, Unit, BigInteger> {

    @Autowired
    UnitRepository repository;

    public UnitController() {
        super(Unit.class);
    }

    @Override
    protected UnitRepository getRepository() {
        return repository;
    }
}
