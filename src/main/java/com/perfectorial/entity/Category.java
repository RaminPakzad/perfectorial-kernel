package com.perfectorial.entity;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class Category extends DescriptorEntity {
    private List<TempDescriptor> courses;

    public List<TempDescriptor> getCourses() {
        return courses;
    }

    public void setCourses(List<TempDescriptor> courses) {
        this.courses = courses;
    }
}
