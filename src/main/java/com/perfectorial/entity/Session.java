package com.perfectorial.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class Session extends DescriptorEntity {
    private List<TempDescriptor> sessionFiles = new ArrayList<>();

    public List<TempDescriptor> getSessionFiles() {
        return sessionFiles;
    }

    public void setSessionFiles(List<TempDescriptor> sessionFiles) {
        this.sessionFiles = sessionFiles;
    }

    @Override
    public DescriptorType getDescriptorType() {
        return DescriptorType.Session;
    }
}
