/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.data;

import java.io.Serializable;

/**
 * Created by Tomasz Szuba
 * Date: 30.12.12
 */
public interface Entity<ID extends Serializable> extends Serializable {
    public ID getId();
}
