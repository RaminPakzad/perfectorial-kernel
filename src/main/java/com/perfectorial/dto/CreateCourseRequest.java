package com.perfectorial.dto;

import com.perfectorial.entity.DescriptorEntity;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/26/2015
 */
public class CreateCourseRequest extends DescriptorEntity{
    private List<CreateSessionRequest> createSessionRequests;
    private String parentCode;

    public List<CreateSessionRequest> getCreateSessionRequests() {
        return createSessionRequests;
    }

    public void setCreateSessionRequests(List<CreateSessionRequest> createSessionRequests) {
        this.createSessionRequests = createSessionRequests;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

}
