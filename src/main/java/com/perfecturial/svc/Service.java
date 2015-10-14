package com.perfecturial.svc;

import com.perfecturial.dto.CategoryFilter;
import com.perfecturial.dto.CreateCategoryRequest;
import com.perfecturial.dto.DownloadRequest;
import com.perfecturial.dto.RegisterUser;
import com.perfecturial.entity.Category;

import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */

public interface Service {
    List<Category> getCategories(CategoryFilter categoryFilter);

    void createCategory(CreateCategoryRequest category);

    boolean createUser(RegisterUser registerUser);

    boolean activeUser(String sessionId);

    boolean requestChangePassword(String sessionId);

    boolean isValidChangePassword(String sessionId);

    boolean changePassword(String sessionId, String newPassword);

    byte[] download(DownloadRequest downloadRequest);
}
