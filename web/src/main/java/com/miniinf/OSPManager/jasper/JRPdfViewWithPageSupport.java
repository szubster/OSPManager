package com.miniinf.OSPManager.jasper;

import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 18.12.12
 * Time: 00:42
 * To change this template use File | Settings | File Templates.
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
}
