/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 02.01.13
 * Equipment that does not need any inspection, can be grouped
 */
@Document
public class CommonEquipment extends Equipment {

    private int count;

    /**
     * Returns number of elements
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets number of elements
     *
     * @param count Number of elements
     */
    public void setCount(int count) {
        this.count = count;
    }
}
