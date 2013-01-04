/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Unit;
import com.miniinf.OSPManager.data.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @RequestMapping()
    public Unit showAll() {
        return unitService.getUnit();
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addcourse")
    public
    @ModelAttribute("course")
    String addCourseGet() throws IllegalAccessException, InstantiationException {
        return "";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addcourse", method = RequestMethod.POST)
    public String addCoursePost(@ModelAttribute("course") String course) {
        unitService.addCourse(course);
        return "redirect:/unit";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/deletecourse", method = RequestMethod.DELETE)
    public String deleteCourse(@RequestParam("course") String course) {
        unitService.deleteCourse(course);
        return "redirect:/unit";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addrank")
    public
    @ModelAttribute("rank")
    String addRankGet() throws IllegalAccessException, InstantiationException {
        return "";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addrank", method = RequestMethod.POST)
    public String addRankPost(@ModelAttribute("rank") String rank) {
        unitService.addRank(rank);
        return "redirect:/unit";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/deleterank", method = RequestMethod.DELETE)
    public String deleteRank(@RequestParam("rank") String rank) {
        unitService.deleteRank(rank);
        return "redirect:/unit";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addaward")
    public
    @ModelAttribute("award")
    String addAwardGet() throws IllegalAccessException, InstantiationException {
        return "";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/addaward", method = RequestMethod.POST)
    public String addAwardPost(@ModelAttribute("award") String award) {
        unitService.addAwards(award);
        return "redirect:/unit";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/deleteaward", method = RequestMethod.DELETE)
    public String deleteAward(@RequestParam("course") String course) {
        unitService.deleteAward(course);
        return "redirect:/unit";
    }
}
