/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import java.io.Serializable;

/**
 * Created by Tomasz Szuba
 * Date: 30.12.12
 * Interface to implement for all elements in database
 */
public interface Entity<ID extends Serializable> extends Serializable {
    /**
     * Returns ID of entity
     *
     * @return
     */
    public ID getId();
}
