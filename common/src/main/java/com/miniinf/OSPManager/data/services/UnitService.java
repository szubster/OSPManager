/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data.services;

import com.miniinf.OSPManager.data.Unit;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Paula
 * Date: 20.01.13
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public interface UnitService {
    @PreAuthorize("hasRole('admin')")
    void resetCounter();

    @PreAuthorize("hasRole('admin')")
    void incrementCounter();

    @PreAuthorize("hasRole('admin')")
    void setCounter(int cnt);

    int getCounter();

    @PreAuthorize("hasRole('admin')")
    void addCourse(String course);

    @PreAuthorize("hasRole('admin')")
    void deleteCourse(String course);

    List<String> showCourses();

    @PreAuthorize("hasRole('admin')")
    void addRank(String rank);

    @PreAuthorize("hasRole('admin')")
    void deleteRank(String rank);

    List<String> showRanks();

    @PreAuthorize("hasRole('admin')")
    void addAwards(String award);

    @PreAuthorize("hasRole('admin')")
    void deleteAward(String award);

    List<String> showAwards();

    Unit getUnit();
}
