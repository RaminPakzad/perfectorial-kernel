package com.perfectorial.entity;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class User implements Entity {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserStatus userStatus;
    private List<SessionFile> sessionFiles;
    private String activeSessionId;

    @Override public String getId() {
        return id;
    }

    @Override public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public List<SessionFile> getSessionFiles() {
        return sessionFiles;
    }

    public void setSessionFiles(List<SessionFile> sessionFiles) {
        this.sessionFiles = sessionFiles;
    }

    public void setActiveSessionId(String activeSessionId) {
        this.activeSessionId = activeSessionId;
    }

    public String getActiveSessionId() {
        return activeSessionId;
    }
}
