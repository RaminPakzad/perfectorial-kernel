package com.perfectorial.entity;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 */
public enum DescriptorType {
    Category,
    Course,
    Session,
    SessionFile;

    public static DescriptorType valueOf(DescriptorEntity entity) {
        if (entity instanceof Category)
            return Category;
        if (entity instanceof Course)
            return Course;
        if (entity instanceof Session)
            return Session;
        if (entity instanceof SessionFile)
            return SessionFile;
        throw new IllegalArgumentException();
    }
}
