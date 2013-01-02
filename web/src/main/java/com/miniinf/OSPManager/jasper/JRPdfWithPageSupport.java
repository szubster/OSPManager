/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.jasper;

import com.miniinf.OSPManager.data.Entity;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.Collection;

/**
 * Created by Tomasz Szuba
 * Date: 18.12.12
 */
public class JRPdfWithPageSupport extends JasperReportsPdfView {

    private static final Class[] REPORT_DATA_TYPES = new Class[]{Collection.class, Object[].class, Page.class, Entity.class};

    @Override
    protected Class[] getReportDataTypes() {
        return REPORT_DATA_TYPES;
    }

    @Override
    protected JRDataSource convertReportData(Object value) throws IllegalArgumentException {
        if (value instanceof Page) {
            Page page = (Page) value;
            return super.convertReportData(page.getContent());
        } else if (value instanceof Entity) {
            Entity[] ds = new Entity[]{(Entity) value};
            return super.convertReportData(ds);
        }
        return super.convertReportData(value);
    }

    @Override
    protected JasperReport loadReport() {
        return super.loadReport();
    }

    @Override
    protected boolean isUrlRequired() {
        return true;
    }
}
