package com.perfectorial.controller;

import com.perfectorial.entity.Category;
import com.perfectorial.logic.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryLogic categoryLogic;

    @RequestMapping(value = URIConstants.Category.CATEGORY, method = RequestMethod.GET)
    public Category getCategory(@PathVariable String id) {
        return categoryLogic.get(id);
    }

    @RequestMapping(value = URIConstants.Category.CATEGORIES, method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryLogic.getAll();
    }

    @RequestMapping(value = URIConstants.Category.CATEGORIES, method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category) {
        return categoryLogic.create(category);
    }
}
