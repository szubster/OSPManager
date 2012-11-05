package com.miniinf.OSPManager.rest.controllers;

import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 15.10.12
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/json/")
public class FireFighterController {

    private static BigInteger ID;

    @Autowired
    FireFighterRepository repository;

    @Autowired
    public FireFighterController(FireFighterRepository repository) {
        FireFighter ff = new FireFighter();
        ff.setBirthDate(DateTime.now().toDate());
        ff.setName("hello");
        ff.setSurname("world");
        ff = repository.save(ff);
        ID = ff.getId();
    }

    @RequestMapping()
    public
    @ResponseBody
    FireFighter get() {
        return repository.findOne(ID);
    }

    @RequestMapping("/json/{id}")
    public FireFighter findById(@PathVariable("id") BigInteger id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public FireFighter add(@RequestParam(value = "name", required = false, defaultValue = "Hello") String name,
                           @RequestParam(value = "surname", required = false, defaultValue = "Hhh") String surname,
                           @RequestParam(value = "date", required = false, defaultValue = "1990-01-01") Date date) {
        FireFighter ff = new FireFighter();
        ff.setBirthDate(date);
        ff.setName(name);
        ff.setSurname(surname);
        ff = repository.save(ff);
        return ff;
    }
}
