/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.util;

import java.util.Comparator;

/**
 * Created by Tomasz Szuba
 * Date: 27.01.13
 */
public class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {

    public int compare(T a, T b) {
        //reverse order of a and b!!!
        return b.compareTo(a);
    }
}
