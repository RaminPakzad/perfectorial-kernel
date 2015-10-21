package com.perfectorial.logic;

import com.perfectorial.dao.CategoryDao;
import com.perfectorial.dao.CourseDao;
import com.perfectorial.entity.Category;
import com.perfectorial.entity.Course;
import com.perfectorial.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/26/2015
 */
@Service
public class Logic {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private SessionDao sessionDao;

    public void createCategory(Category category) {
        //TODO: temp
        category.setImage(new byte[]{1, 2});
        category.setName("category");
        category.setDescription("description");
        category.setLatinName("category");
        category.setKeywords(Arrays.asList("key1", "key2"));
        categoryDao.save(category);
    }

    public void createCourse(Course course) {
        final Category category = categoryDao.getByCode(course.getParentCode());
        category.getCourses().add(course.asTempDescriptor());
        categoryDao.update(category);
        courseDao.save(course);
    }

    public void createSession(Session session) {
        final Course course = courseDao.getByCode(session.getParentCode());
        course.getSessions().add(session.asTempDescriptor());
        courseDao.update(course);
        sessionDao.save(session);
    }
}
