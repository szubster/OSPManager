/*
 * Copyright (c) 2012. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

package com.miniinf.OSPManager.web.controllers;

import com.miniinf.OSPManager.data.Entity;
import com.miniinf.OSPManager.jasper.ReportPath;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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
    }

    protected abstract R getRepository();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid E entity, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("entity", entity);
            return basePath + "/create";
        }
        uiModel.asMap().clear();
        entity = getRepository().save(entity);
        return "redirect:/" + basePath + "/" + entity.getId();
    }

    @RequestMapping(value = "/create")
    public
    @ModelAttribute
    E form() throws IllegalAccessException, InstantiationException {
        return entityClass.newInstance();
    }

    @RequestMapping("/{entity}")
    @ReportPath("show")
    public void show(@ModelAttribute("entity") E entity) {
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ID id) {
        getRepository().delete(id);
    }

    @RequestMapping("/update/{entity}")
    public void edit(@ModelAttribute("entity") E entity) {
    }

    @RequestMapping(value = "/update/{entity}", method = RequestMethod.PUT)
    public String update(@Valid E entity, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("entity", entity);
            return basePath + "/update/" + entity.getId();
        }
        uiModel.asMap().clear();
        entity = getRepository().save(entity);
        return "redirect:/" + basePath + "/" + entity.getId();
    }

    @RequestMapping()
    @ReportPath("/list")
    public
    @ModelAttribute("entities")
    Page<E> list(@Min(1) @RequestParam(value = "page", defaultValue = "1", required = false) int page,
                 @Min(1) @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return getRepository().findAll(new PageRequest(page - 1, size));
    }
}
