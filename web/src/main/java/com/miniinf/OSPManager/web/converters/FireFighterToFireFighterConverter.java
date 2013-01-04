/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.converters;

import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.Operation;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.math.BigInteger;

/**
 * Created by Tomasz Szuba
 * Date: 04.01.13
 */
public class FireFighterToFireFighterConverter implements Converter<String, Operation.FireFighter> {
    @Autowired
    FireFighterRepository repository;

    @Override
    public Operation.FireFighter convert(String source) {
        BigInteger id = new BigInteger(source);
        FireFighter original = repository.findOne(id);
        Operation.FireFighter ret = new Operation.FireFighter();
        ret.setId(original.getId());
        ret.setName(original.getName());
        ret.setSurname(original.getSurname());
        return ret;
    }
}
