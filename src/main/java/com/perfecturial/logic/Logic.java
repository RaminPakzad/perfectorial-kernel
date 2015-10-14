package com.perfecturial.logic;

import com.perfecturial.dao.CategoryDao;
import com.perfecturial.dao.CourseDao;
import com.perfecturial.dto.CreateCategoryRequest;
import com.perfecturial.dto.CreateCourseRequest;
import com.perfecturial.dto.CreateSessionRequest;
import com.perfecturial.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/26/2015
 */
@Service
public class Logic {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    SessionDao sessionDao;

    public void createCategory(CreateCategoryRequest categoryRequest) {
        //temp
        categoryRequest = new CreateCategoryRequest();
        categoryRequest.setImage(new byte[]{1, 2});
        categoryRequest.setName("category");
        categoryRequest.setDescription("description");
        categoryRequest.setLatinName("category");
        categoryRequest.setKeywords(Arrays.asList("key1", "key2"));
        //temp
        Category category = getCategory(categoryRequest);
        categoryDao.save(category);
    }


    private Category getCategory(CreateCategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCode(categoryRequest.getCode());
        category.setDescription(categoryRequest.getDescription());
        category.setImage(categoryRequest.getImage());
        category.setKeywords(categoryRequest.getKeywords());
        category.setName(categoryRequest.getName());
        category.setLatinName(categoryRequest.getLatinName());
        return category;
    }

    public void createCourse(CreateCourseRequest courseRequest) {
        final Category category = categoryDao.getByCode(courseRequest.getParentCode());
        Course course = getCourse(courseRequest, category);
        category.getCourses().add(getTempDescriptor(course));
        categoryDao.update(category);
        courseDao.save(course);
    }


    private Course getCourse(CreateCourseRequest courseRequest, Category category) {
        Course course = new Course();
        course.setCode(courseRequest.getCode());
        course.setDescription(courseRequest.getCode());
        course.setImage(courseRequest.getImage());
        course.setKeywords(courseRequest.getKeywords());
        course.setName(courseRequest.getName());
        course.setLatinName(courseRequest.getLatinName());
        course.setParentCode(category.getCode());
        course.setParentName(category.getName());
        return course;
    }
    public void createSession(CreateSessionRequest createSessionRequest) {
        final Course course = courseDao.getByCode(createSessionRequest.getParentCode());
        Session session = getSession(createSessionRequest, course);
        course.getSessions().add(getTempDescriptor(session));
        courseDao.update(course);
        sessionDao.save(session);
    }

    private Session getSession(CreateSessionRequest createSessionRequest, Course course) {
        Session session = new Session();
        session.setCode(createSessionRequest.getCode());
        session.setDescription(createSessionRequest.getCode());
        session.setImage(createSessionRequest.getImage());
        session.setKeywords(createSessionRequest.getKeywords());
        session.setName(createSessionRequest.getName());
        session.setLatinName(createSessionRequest.getLatinName());
        session.setParentCode(createSessionRequest.getCode());
        session.setParentName(createSessionRequest.getName());
        return session;
    }

    public TempDescriptor getTempDescriptor(DescriptorEntity entity)
    {
        TempDescriptor tempDescriptor = new TempDescriptor();
        tempDescriptor.setCode(entity.getCode());
        tempDescriptor.setName(entity.getName());
        tempDescriptor.setLatinName(entity.getLatinName());
        tempDescriptor.setImage(entity.getImage());
        tempDescriptor.setDescription(entity.getDescription());
        return tempDescriptor;
    }


}
