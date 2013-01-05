/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Entity;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tomasz Szuba
 * Date: 30.12.12
 */
public abstract class AbstractController<R extends MongoRepository<E, ID>, E extends Entity<ID>, ID extends Serializable> {

    private final Class<E> entityClass;

    private final String basePath;

    protected final String className;

    public AbstractController(Class<E> entityClass) {
        Controller annotation = AnnotationUtils.findAnnotation(this.getClass(), Controller.class);
        if (annotation == null) {
            throw new IllegalStateException("Classes extending AbstraController must have @Controller annotation");
        }
        RequestMapping mapping = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
        if (mapping != null) {
            switch (mapping.value().length) {
                case 0:
                    basePath = "";
                    break;
                case 1:
                    basePath = mapping.value()[0];
                    break;
                default:
                    throw new IllegalStateException("Classes extending from AbstractController " +
                                                            "cannot have more than one mapping");
            }
        } else {
            basePath = "";
        }
        try {
            entityClass.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Entity needs to have parameterless constructor", e);
        }
        this.entityClass = entityClass;
        this.className = StringUtils.uncapitalize(entityClass.getSimpleName());
    }

    protected abstract R getRepository();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid E entity, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            addAdditionalData(uiModel);
            System.out.print(bindingResult);
            System.out.print(bindingResult.getAllErrors());
            uiModel.addAttribute(className, entity);
            return basePath + "/create";
        }
        return saveAndRedirect(entity, uiModel);
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/create")
    public void form(Model uiModel) throws IllegalAccessException, InstantiationException {
        addAdditionalData(uiModel);
        E entity = entityClass.newInstance();
        entity = preProcessData(entity);
        uiModel.addAttribute(className, entity);
    }

    @RequestMapping("/{entity}")
    @ReportPath("show")
    public void show(@ModelAttribute("entity") E entity) {
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable ID id) {
        getRepository().delete(id);
        return "redirect:/" + basePath;
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/update/{id}")
    public void edit(@PathVariable() ID id, Model uiModel) {
        addAdditionalData(uiModel);
        uiModel.addAttribute(className, getRepository().findOne(id));
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/update/{entity}", method = RequestMethod.PUT)
    public String update(@Valid E entity, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            addAdditionalData(uiModel);
            uiModel.addAttribute(className, entity);
            return basePath + "/update/" + entity.getId();
        }
        return saveAndRedirect(entity, uiModel);
    }

    private String saveAndRedirect(E entity, Model uiModel) {
        uiModel.asMap().clear();
        entity = postProcessData(entity);
        entity = getRepository().save(entity);
        return "redirect:/" + basePath + "/" + entity.getId();
    }

    @RequestMapping()
    @ReportPath("list")
    public
    @ModelAttribute("entities")
    Page<E> list(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                 @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        if (size == -1) {
            size = Integer.MAX_VALUE;
        }
        return getRepository().findAll(new PageRequest(page - 1, size));
    }

    protected void addAdditionalData(Model uiModel) {}

    protected E preProcessData(E entity) {
        return entity;
    }

    protected E postProcessData(E entity) {
        return entity;
    }
}
