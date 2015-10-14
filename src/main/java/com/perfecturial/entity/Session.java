package com.perfecturial.entity;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class Session extends DescriptorEntity {
    private List<TempDescriptor> sessionFiles;

    public List<TempDescriptor> getSessionFiles() {
        return sessionFiles;
    }

    public void setSessionFiles(List<TempDescriptor> sessionFiles) {
        this.sessionFiles = sessionFiles;
    }
}
