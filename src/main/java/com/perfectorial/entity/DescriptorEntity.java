package com.perfectorial.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public abstract class DescriptorEntity implements Entity {
    private String id;
    private String name;
    private String latinName;
    private String code;
    private String description;
    private DescriptorType descriptorType;
    private String parentCode;
    private String parentName;
    private byte[] image;
    private List<String> keywords = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public abstract DescriptorType getDescriptorType();

    public void setDescriptorType(DescriptorType descriptorType) {
        this.descriptorType = descriptorType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public TempDescriptor asTempDescriptor() {
        TempDescriptor tempDescriptor = new TempDescriptor();
        tempDescriptor.setCode(this.getCode());
        tempDescriptor.setName(this.getName());
        tempDescriptor.setLatinName(this.getLatinName());
        tempDescriptor.setImage(this.getImage());
        tempDescriptor.setDescription(this.getDescription());
        return tempDescriptor;
    }
}
