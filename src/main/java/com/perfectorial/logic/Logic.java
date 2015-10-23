package com.perfectorial.logic;

import com.perfectorial.dao.CategoryDao;
import com.perfectorial.dao.CourseDao;
import com.perfectorial.dao.SessionDao;
import com.perfectorial.entity.Category;
import com.perfectorial.entity.Course;
import com.perfectorial.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/26/2015
 * @deprecated Because it doesn't implement any particular entity logic. Services that are
 * related to a specific entity should be moved to its own class and those that are common
 * among all logic classes should be moved to {@link com.perfectorial.logic.AbstractGenericLogic AbstractGenericLogic}.
 * This can be safely removed after method transformations.
 */
@Deprecated
@Service
public class Logic {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private SessionDao sessionDao;
    @Autowired
    private CategoryDao categoryDao;

    public void createCourse(Course course) {
        final Category category = categoryDao.getByCode(course.getParentCode());
        category.getCourses().add(course.asTempDescriptor());
        categoryDao.update(category);
        courseDao.create(course);
    }

    public void createSession(Session session) {
        final Course course = courseDao.getByCode(session.getParentCode());
        course.getSessions().add(session.asTempDescriptor());
        courseDao.update(course);
        sessionDao.create(session);
    }
}
