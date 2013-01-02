/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.InspectionEquipment;
import com.miniinf.OSPManager.data.repositories.InspectionEquipmentRepository;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("inspectionequipment")
@ReportPath("/inspectionequipment/")
public class InspectionEquipmentController extends AbstractController<InspectionEquipmentRepository, InspectionEquipment, BigInteger> {

    @Autowired
    InspectionEquipmentRepository repository;


    public InspectionEquipmentController() {
        super(InspectionEquipment.class);
    }

    @Override
    protected InspectionEquipmentRepository getRepository() {
        return repository;
    }
}
