package com.perfectorial.entity;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 */
public enum DescriptorType {
    Category,
    Course,
    Session,
    SessionFile;

    public static DescriptorType valueOf(Object o) {
        if (o instanceof Category)
            return Category;
        if (o instanceof Course)
            return Course;
        if (o instanceof Session)
            return Session;
        if (o instanceof SessionFile)
            return SessionFile;
        throw new IllegalArgumentException();
    }
}
