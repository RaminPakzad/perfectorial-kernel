package com.perfecturial.svc;

import com.perfecturial.dto.CategoryFilter;
import com.perfecturial.dto.CreateCategoryRequest;
import com.perfecturial.dto.DownloadRequest;
import com.perfecturial.dto.RegisterUser;
import com.perfecturial.entity.Category;
import com.perfecturial.logic.Logic;
import com.perfecturial.logic.FileLogic;
import com.perfecturial.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private Logic categoryLogic;
    @Autowired
    private UserLogic userLogic;
    @Autowired
    private FileLogic fileLogic;

    @Override
    public List<Category> getCategories(CategoryFilter categoryFilter) {
        return null;
    }

    @Override
    public void createCategory(CreateCategoryRequest category) {
        categoryLogic.createCategory(category);
    }

    @Override
    public boolean createUser(RegisterUser registerUser) {
        return userLogic.createUser(registerUser);
    }

    @Override
    public boolean activeUser(String sessionId) {
        return userLogic.activeUser(sessionId);
    }

    @Override
    public boolean requestChangePassword(String sessionId) {
        return userLogic.requestChangePassword(sessionId);
    }

    @Override
    public boolean isValidChangePassword(String sessionId) {
        return userLogic.isValidChangePassword(sessionId);
    }


    @Override
    public boolean changePassword(String sessionId, String newPassword) {
        return userLogic.changePassword(sessionId, newPassword);
    }

    @Override public byte[] download(DownloadRequest downloadRequest) {
        return fileLogic.download(downloadRequest);
    }


}
