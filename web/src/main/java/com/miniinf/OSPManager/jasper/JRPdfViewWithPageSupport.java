/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.jasper;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Tomasz Szuba
 * Date: 18.12.12
 */
public class JRPdfViewWithPageSupport extends JasperReportsPdfView {

    private static final Class[] REPORT_DATA_TYPES = new Class[]{Collection.class, Object[].class, Page.class};

    @Override
    protected Class[] getReportDataTypes() {
        return REPORT_DATA_TYPES;
    }

    @Override
    protected JRDataSource convertReportData(Object value) throws IllegalArgumentException {
        if (value instanceof Page) {
            Page page = (Page) value;
            return super.convertReportData(page.getContent());
        }
        return super.convertReportData(value);
    }

    @Override
    protected JasperReport loadReport() {
        try {
            return super.loadReport();
        } catch (ApplicationContextException e) {
            if (e.getCause() instanceof IOException) {
                return null;
            }
            throw e;
        }
    }

    @Override
    protected boolean isUrlRequired() {
        return true;
    }
}
