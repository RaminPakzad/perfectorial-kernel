package com.perfectorial.entity;

import java.io.Serializable;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public interface Entity extends Serializable {
    String getId();

    void setId(String id);
}
