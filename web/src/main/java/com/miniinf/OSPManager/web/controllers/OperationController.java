/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Operation;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.data.repositories.OperationRepository;
import com.miniinf.OSPManager.data.services.FireTruckService;
import com.miniinf.OSPManager.data.services.UnitService;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("operation")
@ReportPath("/operation/")
public class OperationController extends AbstractController<OperationRepository, Operation, BigInteger> {

    @Autowired
    OperationRepository repository;

    @Autowired
    FireFighterRepository FFRepository;

    @Autowired
    UnitService unitService;

    @Autowired
    FireTruckService fireTruckService;

    public OperationController() {
        super(Operation.class);
    }

    @Override
    protected OperationRepository getRepository() {
        return repository;
    }

    @Override
    protected void addAdditionalData(Model uiModel) {
        uiModel.addAttribute("firefighters", FFRepository.findAll());
        uiModel.addAttribute("firetrucks", fireTruckService.findAll());
    }

    @Override
    protected Operation preProcessData(Operation entity) {
        entity.setNumber(unitService.getCounter());
        return entity;
    }

    @Override
    protected Operation postProcessData(Operation entity) {
        unitService.setCounter(entity.getNumber() + 1);
        return entity;
    }

    @Override
    protected String getRedirectPath(Operation entity) {
        return "redirect:/operation/" + entity.getId() + "/settime";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/{id}/settime")
    public void setTime(@PathVariable() BigInteger id, Model uiModel) {

        Operation operation = repository.findOne(id);
        List<Operation.FireFighter> participants = operation.getParticipants();
        DateTime start = operation.getStartDate().toDateTime(operation.getStartTime());
        DateTime end = operation.getEndDate().toDateTime(operation.getEndTime());
        Duration duration = new Duration(start, end);
        for (Operation.FireFighter fireFighter : participants) {
            if (fireFighter.getOperatingTime() == null) {
                fireFighter.setOperatingTime(duration);
            }
            if (fireFighter.getPaidTime() == null) {
                fireFighter.setPaidTime(duration);
            }
        }
        uiModel.addAttribute("operationId", operation.getId());
        uiModel.addAttribute("firefighters", new FireFightersFormBackingObject(participants));
    }

    public static class FireFightersFormBackingObject {
        List<Operation.FireFighter> fireFighters;

        public FireFightersFormBackingObject(List<Operation.FireFighter> fireFighters) {
            this.fireFighters = fireFighters;
        }

        public List<Operation.FireFighter> getFireFighters() {
            return fireFighters;
        }

        public void setFireFighters(List<Operation.FireFighter> fireFighters) {
            this.fireFighters = fireFighters;
        }
    }
}
