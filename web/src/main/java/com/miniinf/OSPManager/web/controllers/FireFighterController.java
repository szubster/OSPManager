/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Address;
import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    public FireFighterController() {
        super(FireFighter.class);
    }

    @Override
    protected FireFighterRepository getRepository() {
        return repository;
    }

    @Override
    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid FireFighter entity, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.getFieldErrorCount("name") > 0) {
                uiModel.addAttribute("information", "com.miniinf.OSPManager.simplepropertyfix");
                entity.setName(StringUtils.capitalize(entity.getName()));
            }
            if (bindingResult.getFieldErrorCount("secondName") > 0) {
                uiModel.addAttribute("information", "com.miniinf.OSPManager.simplepropertyfix");
                entity.setSecondName(StringUtils.capitalize(entity.getSecondName()));
            }
            if (bindingResult.getFieldErrorCount("surname") > 0) {
                uiModel.addAttribute("information", "com.miniinf.OSPManager.simplepropertyfix");
                entity.setSurname(StringUtils.capitalize(entity.getSurname()));
            }
            if (bindingResult.getFieldErrorCount("address") > 0) {
                if (bindingResult.getFieldErrorCount("address.street") > 0) {
                    uiModel.addAttribute("information", "com.miniinf.OSPManager.simplepropertyfix");
                    Address ad = entity.getAddress();
                    ad.setStreet(StringUtils.capitalize(ad.getStreet()));
                    entity.setAddress(ad);
                }
                if (bindingResult.getFieldErrorCount("address.city") > 0) {
                    uiModel.addAttribute("information", "com.miniinf.OSPManager.simplepropertyfix");
                    Address ad = entity.getAddress();
                    ad.setCity(StringUtils.capitalize(ad.getCity()));
                    entity.setAddress(ad);
                }
            }
        }
        return super.create(entity, bindingResult, uiModel);
    }
}
