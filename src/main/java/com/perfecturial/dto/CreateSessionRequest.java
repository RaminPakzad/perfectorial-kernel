package com.perfecturial.dto;

import com.perfecturial.entity.DescriptorEntity;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/26/2015
 */
public class CreateSessionRequest extends DescriptorEntity {
    private String parentCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
