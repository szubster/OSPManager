/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.data.services.UnitService;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 27.11.12
 */
@Controller
@RequestMapping("firefighter")
@ReportPath("/firefighter/")
public class FireFighterController extends AbstractController<FireFighterRepository, FireFighter, BigInteger> {

    @Autowired
    FireFighterRepository repository;

    @Autowired
    UnitService unitService;

    public FireFighterController() {
        super(FireFighter.class);
    }

    @Override
    protected FireFighterRepository getRepository() {
        return repository;
    }

    @Override
    protected void addAdditionalData(Model uiModel) {
        uiModel.addAttribute("courses", unitService.showCourses());
        uiModel.addAttribute("ranks", unitService.showRanks());
        uiModel.addAttribute("awards", unitService.showAwards());
    }
}
