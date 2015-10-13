package com.perfectorial.svc;

import com.perfectorial.dto.CategoryFilter;
import com.perfectorial.dto.CreateCategoryRequest;
import com.perfectorial.dto.DownloadRequest;
import com.perfectorial.dto.RegisterUser;
import com.perfectorial.entity.Category;
import com.perfectorial.logic.Logic;
import com.perfectorial.logic.FileLogic;
import com.perfectorial.logic.UserLogic;
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
