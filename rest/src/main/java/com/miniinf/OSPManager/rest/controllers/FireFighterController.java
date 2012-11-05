package com.miniinf.OSPManager.rest.controllers;

import com.miniinf.OSPManager.data.FireFighter;
import com.miniinf.OSPManager.data.repositories.FireFighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("fireFighter")
public class FireFighterController {

    @Autowired
    FireFighterRepository repository;

    @RequestMapping("get")
    public
    Iterable<FireFighter> get(@RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "surname", required = false) String surname,
                    @RequestParam(value = "birthDate", required = false) Date date) {
        if(name!=null){
            if(surname!=null)
                return repository.findByNameAndSurname(name,surname);
            return repository.findByName(name);
        }
        if(surname!=null)
            return repository.findBySurname(surname);
        if(date!=null)
            return repository.findByBirthDate(date);
        return repository.findAll();
        //po imnieniu, nazwisku,obu, 2 datach,
    }

    @RequestMapping("get/{id}")
    public FireFighter findById(@PathVariable("id") BigInteger id) {
        return repository.findOne(id);
    }

    @RequestMapping("getAll")
    public
    Iterable<FireFighter> getAll() {
        return repository.findAll() ;
    }
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public
    FireFighter add(@RequestParam(value = "name", required = true) String name,
                    @RequestParam(value = "surname", required = true) String surname,
                    @RequestParam(value = "birthDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        FireFighter ff = new FireFighter();
        ff.setBirthDate(date);
        ff.setName(name);
        ff.setSurname(surname);
        ff = repository.save(ff);
        return ff;
    }

    @RequestMapping("delete/{id}")
    public
    String delete(@PathVariable("id") BigInteger id) {
        repository.delete(id);
        return "Delete succeeded";

    }

    @RequestMapping("update/{id}")
    public
    FireFighter update(@PathVariable("id") BigInteger id,
                    @RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "surname", required = false) String surname,
                    @RequestParam(value = "birthDate", required = false) Date date) {
        FireFighter ff = repository.findOne(id);
        if(date!=null)
            ff.setBirthDate(date);
        if(name!=null)
            ff.setName(name);
        if(surname!=null)
            ff.setSurname(surname);
        ff = repository.save(ff);
        return ff;
    }



}
