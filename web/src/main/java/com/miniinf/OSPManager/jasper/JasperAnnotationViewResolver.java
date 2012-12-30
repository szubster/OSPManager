/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.jasper;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 23.12.12
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class JasperAnnotationViewResolver extends JasperReportsViewResolver {

    private Map<String, String> urlToReportPathMap = new HashMap<String, String>();

    private AntPathMatcher matcher = new AntPathMatcher();

    public void addReportPath(String pattern, String reportPath) {
        urlToReportPathMap.put(pattern, reportPath);
    }

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        AbstractUrlBasedView view = buildView(viewName);
        if (view == null) {
            return null;
        }
        View result = applyLifecycleMethods(viewName, view);
        return (view.checkResource(locale) ? result : null);
    }

    private View applyLifecycleMethods(String viewName, AbstractView view) {
        return (View) getApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        for (Map.Entry<String, String> entry : urlToReportPathMap.entrySet()) {
            if (matcher.match(entry.getKey(), viewName)) {
                return super.buildView(entry.getValue());
            }
        }
        return null;
    }
}
