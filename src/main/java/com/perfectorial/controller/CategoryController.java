package com.perfectorial.controller;

import com.perfectorial.entity.Category;
import com.perfectorial.logic.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryLogic categoryLogic;

    @RequestMapping(value = URIConstants.Category.CATEGORIES, method = RequestMethod.GET)
    public Category getCategories() {
        categoryLogic.getAll();
        return new Category();
    }

    @RequestMapping(value = URIConstants.Category.CATEGORIES, method = RequestMethod.POST)
    public Integer createCategory(@RequestBody Category category) {
        categoryLogic.create(category);
        return 1;
    }
}
