package com.perfecturial.controller;

import com.perfecturial.dto.CategoryFilter;
import com.perfecturial.entity.Category;
import com.perfecturial.svc.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    Service service;

    @RequestMapping(value = URIConstants.Category.GET_ALL, method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategories(@RequestBody CategoryFilter categoryFilter) {
        return service.getCategories(categoryFilter);
    }
    @RequestMapping(value = URIConstants.Category.CREATE, method = RequestMethod.GET)
    public @ResponseBody Integer createCategory() {
        service.createCategory(null);
        return 1;
    }

}
