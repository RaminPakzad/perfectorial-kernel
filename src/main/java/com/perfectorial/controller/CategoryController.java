package com.perfectorial.controller;

import com.perfectorial.entity.Category;
import com.perfectorial.logic.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryLogic categoryLogic;

    @RequestMapping(value = URIConstants.Category.CATEGORIES, method = RequestMethod.GET
            , consumes = "application/json"
            , produces = "application/json")
    @ResponseBody
    public HashMap<String, String> getCategories() {
        categoryLogic.getAll();
        return null;
    }

    @RequestMapping(value = URIConstants.Category.CATEGORY, method = RequestMethod.POST)
    public @ResponseBody Integer createCategory(@RequestBody Category category) {
        categoryLogic.create(category);
        return 1;
    }
}
