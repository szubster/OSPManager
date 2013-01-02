/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.CommonEquipment;
import com.miniinf.OSPManager.data.repositories.CommonEquipmentRepository;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("commonequipment")
@ReportPath("/commonequipment/")
public class CommonEquipmentController extends AbstractController<CommonEquipmentRepository, CommonEquipment, BigInteger> {

    @Autowired
    CommonEquipmentRepository repository;

    public CommonEquipmentController() {
        super(CommonEquipment.class);
    }

    @Override
    protected CommonEquipmentRepository getRepository() {
        return repository;
    }
}
