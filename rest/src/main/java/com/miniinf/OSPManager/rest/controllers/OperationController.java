/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.rest.controllers;

import com.miniinf.OSPManager.data.Address;
import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.Operation;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import com.miniinf.OSPManager.data.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 05.11.12
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("operation/")
public class OperationController {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    FireFighterRepository fighterRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("get/{operation}")
    public void findById(@ModelAttribute("operation") Operation op) {
    }

    @RequestMapping("getAll")
    public
    @ModelAttribute("AllOperations")
    Iterable<Operation> getAll() {
        return operationRepository.findAll();
    }

    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public void add(@ModelAttribute Operation op) {
        operationRepository.save(op);
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") BigInteger id) {
        operationRepository.delete(id);
        return "Delete succeeded";

    }

    @RequestMapping("update/{id}")
    public Operation update(@PathVariable("id") BigInteger id,
                            @ModelAttribute(value = "place") Address place,
                            @RequestParam(value = "date", required = false) Date date) {
        Operation op = operationRepository.findOne(id);
        if (date != null)
            //op.setDate(date);
            if (place != null)
                op.setPlace(place);
        op = operationRepository.save(op);
        return op;
    }

    @RequestMapping(value = "get/{id}/addParticipant/{participantId}", method = RequestMethod.PUT)
    public Operation add(@PathVariable("id") BigInteger id, @PathVariable("participantId") BigInteger participantId) {

        Operation op = operationRepository.findOne(id);
        FireFighter ff = fighterRepository.findOne(participantId);
        Operation.FireFighter _ff = new Operation.FireFighter();
        _ff.setId(ff.getId());
        _ff.setName(ff.getName());
        _ff.setSurname(ff.getSurname());
        if (op.getParticipants() == null)
            op.setParticipants(new ArrayList<Operation.FireFighter>());
        op.getParticipants().add(_ff);
        op = operationRepository.save(op);
        return op;
    }

}
