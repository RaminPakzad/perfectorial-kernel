package com.perfectorial.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class Course extends DescriptorEntity {
    private List<TempDescriptor> sessions = new ArrayList<>();


    public List<TempDescriptor> getSessions() {
        return sessions;
    }

    public void setSessions(List<TempDescriptor> sessions) {
        this.sessions = sessions;
    }

    @Override
    public DescriptorType getDescriptorType() {
        return DescriptorType.Course;
    }
}
